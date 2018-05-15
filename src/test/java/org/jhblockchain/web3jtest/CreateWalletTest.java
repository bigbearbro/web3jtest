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
public class CreateWalletTest extends BaseTest {

	@Test
	public void testApp() {
		try {
			String fileName = WalletUtils.generateFullNewWalletFile(
					        "your password",
					        new File("/Users/wuwei/prieth/data/00/keystore"));
			Log.log("new wallet created:" + fileName);
			
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException
						| CipherException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
