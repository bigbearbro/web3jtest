package org.jhblockchain.web3jtest;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;
import org.web3j.crypto.Bip39Wallet;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

/**
 * Unit test for simple App.
 */
public class CreateBip39WalletTest extends BaseTest {

	@Test
	public void testApp() {
		Bip39Wallet bip39;
		try {
			bip39 = WalletUtils.generateBip39Wallet("your password", new File("/Users/wuwei/prieth/data/00/keystore"));
			Log.log("new bip 39 wallet created:" + bip39.getFilename() + ",mnemonic:" + bip39.getMnemonic());
		} catch (CipherException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
