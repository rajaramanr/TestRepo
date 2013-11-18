package com.ssn.artiflow.test;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCreateDumpXML {
	static Calendar cal = Calendar.getInstance();
	static int fileNumber = 1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int startDate = 01, startMonth = 0, startYear = 2013;
		int endDate = 01, endMonth = 0, endYear = 2063;
		cal.set(startYear, startMonth, startDate);
		Timestamp start = new Timestamp(cal.getTimeInMillis());
		cal.set(endYear, endMonth, endDate);
		Timestamp end = new Timestamp(cal.getTimeInMillis());
		do {
			getDatesForReview(start, startYear);
			cal.set(++startYear, startMonth, startDate);
			start.setTime(cal.getTimeInMillis());
		} while (start.getTime() < end.getTime());
	}

	private static void getDatesForReview(Timestamp start, int startYear) {
		int count = 0;
		do {
			Timestamp reviewStart = getRandomDate(startYear);
			Timestamp reviewEnd = getRandomDate(startYear);
			if (reviewEnd.getTime() > reviewStart.getTime()) {
				count++;
				try {
					appendToContent(reviewStart, reviewEnd);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} while (count != 24);
	}

	private static void appendToContent(Timestamp reviewStart,
			Timestamp reviewEnd) throws IOException {
		DateFormat df = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		String start = df.format(reviewStart);
		String end = df.format(reviewEnd);
		System.out.println("<event start=\""+ start +" GMT\" end=\"" + end +" GMT\" isDuration=\"true\" title=\"Create Review screen"+ fileNumber++ +"\" image=\"https://si0.twimg.com/profile_images/1679093578/logo_normal.jpg\"> To review the code related to the development of the initiate review screen.&lt;br/&gt; &lt;b&gt;File names:&lt;b/&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;Test.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;User.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;Review.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;CreateReview.java&lt;/i&gt;&lt;/a&gt;To review the code related to the development of the initiate review screen.&lt;br/&gt; &lt;b&gt;File names:&lt;b/&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;Test.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;User.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;Review.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;CreateReview.java&lt;/i&gt;&lt;/a&gt;To review the code related to the development of the initiate review screen.&lt;br/&gt; &lt;b&gt;File names:&lt;b/&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;Test.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;User.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;Review.java&lt;/i&gt;&lt;/a&gt;&lt;br/&gt; &lt;a href=&quot;http://test.test &quot;&gt;&lt;i&gt;CreateReview.java&lt;/i&gt;&lt;/a&gt;</event>");
	}

	private static Timestamp getRandomDate(int year) {
		int date = (int) (Math.random() * 28);
		int month = (int) (Math.random() * 11);
		cal.set(year, month, date);
		return new Timestamp(cal.getTimeInMillis());
	}

}
