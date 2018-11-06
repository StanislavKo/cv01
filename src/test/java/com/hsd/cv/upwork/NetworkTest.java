package com.hsd.cv.upwork;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.hsd.cv.upwork.network.Network;
import com.hsd.cv.upwork.network2.Network2;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NetworkTest {

	@Test
	public void testNetwork() throws Exception {
		Network network = new Network(10);
		network.connect(1, 2);
		network.connect(2, 4);
		network.connect(1, 6);
		network.connect(2, 6);
		network.connect(5, 8);
		assertTrue(network.query(1, 1));
		assertTrue(network.query(1, 4));
		assertTrue(network.query(4, 1));
		assertTrue(network.query(1, 2));
		assertFalse(network.query(1, 8));
		assertFalse(network.query(7, 8));
	}

	@Test
	public void testNetwork2() throws Exception {
		Network2 network = new Network2(10);
		network.connect(1, 2);
		network.connect(2, 4);
		network.connect(1, 6);
		network.connect(2, 6);
		network.connect(5, 8);
		assertTrue(network.query(1, 1));
		assertTrue(network.query(1, 4));
		assertTrue(network.query(4, 1));
		assertTrue(network.query(1, 2));
		assertFalse(network.query(1, 8));
		assertFalse(network.query(7, 8));
	}

	@Test
	public void testNetworkIllegalArgumentExceptions() throws Exception {
		try {
			Network network = new Network(-10);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network network = new Network(10);
			network.connect(-1, 5);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network network = new Network(10);
			network.connect(1, 15);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network network = new Network(10);
			network.query(-1, 5);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network network = new Network(10);
			network.query(1, 15);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testNetwork2IllegalArgumentExceptions() throws Exception {
		try {
			Network2 network = new Network2(-10);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network2 network = new Network2(10);
			network.connect(-1, 5);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network2 network = new Network2(10);
			network.connect(1, 15);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network2 network = new Network2(10);
			network.query(-1, 5);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			Network2 network = new Network2(10);
			network.query(1, 15);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

}
