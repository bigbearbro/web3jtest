package org.jhblockchain.web3jtest;

import java.io.IOException;

import org.junit.Test;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

/**
 * Unit test for simple App.
 */
public class SyncTest extends BaseTest {
	public Web3ClientVersion web3ClientVersion;

	@Test
	public void testApp() {
		try {
			web3ClientVersion = web3j.web3ClientVersion().send();
			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			System.out.println("clientVersion:" + clientVersion);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
