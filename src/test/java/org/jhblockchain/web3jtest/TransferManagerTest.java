package org.jhblockchain.web3jtest;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

/**
 * Unit test for simple App.
 */
public class TransferManagerTest extends BaseTest {

	@Test
	public void testApp() {
		try {
			//这个方法会阻塞，非阻塞用asyncsend
			// 内部同rawtrancaction
			TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j, credentials, "0x6e06dad5fc96607d216593ac78d5294e716efe80",
							BigDecimal.valueOf(1.0), Convert.Unit.ETHER).send();
			
			Log.log(transactionReceipt.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
