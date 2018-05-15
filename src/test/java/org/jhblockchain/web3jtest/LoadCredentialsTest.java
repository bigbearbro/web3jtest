package org.jhblockchain.web3jtest;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

/**
 * Unit test for simple App.
 */
public class LoadCredentialsTest extends BaseTest {

	@Test
	public void testApp()  {
		Credentials credentials;
		try {
			credentials = WalletUtils.loadCredentials(
					        "your password",
					        "/Users/wuwei/prieth/data/00/keystore/UTC--2018-05-11T05-48-05.867000000Z--6e06dad5fc96607d216593ac78d5294e716efe80.json");
			Log.log("credentials loaded, address:" + credentials.getAddress());
		} catch (IOException | CipherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
