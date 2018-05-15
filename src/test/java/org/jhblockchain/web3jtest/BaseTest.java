package org.jhblockchain.web3jtest;

import java.io.IOException;
import java.math.BigInteger;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.http.HttpService;

public class BaseTest {
	public Web3j web3j;
	public Admin web3jAdmin;
	Credentials credentials;

	public BaseTest() {
		// defaults to 8545
		web3j = web3jAdmin = Admin.build(new HttpService("http://localhost:8200"));
		try {
			credentials = WalletUtils
							.loadCredentials("123456",
											"/Users/wuwei/prieth/data/00/keystore/UTC--2018-05-08T08-47-54.966429455Z--aab8bcded48300340cd54381b0be22d563f886c5");
		} catch (IOException | CipherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pending() {
		for(;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * 获取指定地址的可用nonce
	 */
	public BigInteger getNonce(String address) throws IOException {
		return web3j.ethGetTransactionCount(address, DefaultBlockParameterName.PENDING).send().getTransactionCount();
	}
}
