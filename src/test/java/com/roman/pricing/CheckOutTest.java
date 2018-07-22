package com.roman.pricing;

import static org.junit.Assert.*;
import org.junit.Test;

public class CheckOutTest {

	@Test
	public void testTotals() throws Exception {
		assertEquals(Integer.valueOf(0), price(""));
		assertEquals(Integer.valueOf(50), price("A"));
		assertEquals(Integer.valueOf(80), price("AB"));
		assertEquals(Integer.valueOf(115), price("CDBA"));

		assertEquals(Integer.valueOf(100), price("AA"));
		assertEquals(Integer.valueOf(130), price("AAA"));
		assertEquals(Integer.valueOf(180), price("AAAA"));
		assertEquals(Integer.valueOf(230), price("AAAAA"));
		assertEquals(Integer.valueOf(260), price("AAAAAA"));

		assertEquals(Integer.valueOf(160), price("AAAB"));
		assertEquals(Integer.valueOf(175), price("AAABB"));
		assertEquals(Integer.valueOf(190), price("AAABBD"));
		assertEquals(Integer.valueOf(190), price("DABABA"));

	}

	private Integer price(String goods) {
		CheckOut co = new CheckOut();

		for (int i = 0; i < goods.length(); i++) {
			co.scan(goods.substring(i, i + 1));
		}
		return co.total();
	}

	@Test
	public void testIncremental() throws Exception {
		CheckOut co = new CheckOut();
		assertEquals(new Integer(0), co.total());

		co.scan("A");
		assertEquals(Integer.valueOf(50), co.total());
		co.scan("B");
		assertEquals(Integer.valueOf(80), co.total());
		co.scan("A");
		assertEquals(Integer.valueOf(130), co.total());
		co.scan("A");
		assertEquals(Integer.valueOf(160), co.total());
		co.scan("B");
		assertEquals(Integer.valueOf(175), co.total());
	}

}