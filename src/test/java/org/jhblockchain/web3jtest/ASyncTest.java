package org.jhblockchain.web3jtest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

/**
 * Unit test for simple App.
 */
public class ASyncTest extends BaseTest {
	public Web3ClientVersion web3ClientVersion;

	@Test
	public void testApp() {
		try {
			CompletableFuture<Web3ClientVersion> future = web3j.web3ClientVersion().sendAsync();
			web3ClientVersion = future.get();
			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
			System.out.println("clientVersion:" + clientVersion);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
