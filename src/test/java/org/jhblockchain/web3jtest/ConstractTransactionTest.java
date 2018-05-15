package org.jhblockchain.web3jtest;

import java.io.IOException;
import java.math.BigInteger;

import org.junit.Test;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

/**
 * 交易签名
 */
public class ConstractTransactionTest extends BaseTest {

	@Test
	public void testApp() throws IOException {
		PersonalUnlockAccount personalUnlockAccount = web3jAdmin.personalUnlockAccount(getSomeAccount(), getSomePwd())
						.send();
		if(personalUnlockAccount.accountUnlocked()) {
			Log.log("account unlock: " + getSomeAccount());

			Transaction transaction = Transaction.createContractTransaction(getSomeAccount(),
							getNonce(getSomeAccount()), BigInteger.valueOf(300000L),
							"0x...<smart contract code to execute>");
			EthSendTransaction transactionResponse = web3j.ethSendTransaction(transaction).send();

			String transactionHash = transactionResponse.getTransactionHash();

			// poll for transaction response via
			// org.web3j.protocol.Web3j.ethGetTransactionReceipt(<txHash>)

		}
	}

	private String getSomePwd() {
		return "123456";
	}

	private String getSomeAccount() {
		return "0xaab8bcded48300340cd54381b0be22d563f886c5";
	}
}
