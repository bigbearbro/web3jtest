package org.jhblockchain.web3jtest;

import java.math.BigInteger;

import org.junit.Test;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Convert;

/**
 * Unit test for simple App.
 */
public class TransferTest extends BaseTest {

	@Test
	public void testApp() {
		try {
			BigInteger nonce = getNonce("0xaab8bcded48300340cd54381b0be22d563f886c5");
//			nonce = new BigInteger("35");
			Log.log("nonce:" + nonce.toString());
			PersonalUnlockAccount personalUnlockAccount = web3jAdmin.personalUnlockAccount("0xaab8bcded48300340cd54381b0be22d563f886c5", "123456").send();
			if (!personalUnlockAccount.hasError() && personalUnlockAccount.accountUnlocked()) {
			    // send a transaction
				BigInteger value = Convert.toWei("1.0", Convert.Unit.ETHER).toBigInteger();
				EthSendTransaction t = web3j.ethSendTransaction(Transaction.createEtherTransaction("0xaab8bcded48300340cd54381b0be22d563f886c5", 
								nonce, web3j.ethGasPrice().send()
								.getGasPrice(), BigInteger.valueOf(21000),
								"0x6e06dad5fc96607d216593ac78d5294e716efe80", value)).sendAsync().get();
				Log.log("TransactionHash:" + t.getTransactionHash());
				return;
			}
			Log.log(personalUnlockAccount.getError().getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
