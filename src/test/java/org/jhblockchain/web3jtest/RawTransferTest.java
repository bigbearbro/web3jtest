package org.jhblockchain.web3jtest;

import java.math.BigInteger;

import org.junit.Test;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

/**
 * Unit test for simple App.
 */
public class RawTransferTest extends BaseTest {

	@Test
	public void testApp() {
		try {
			BigInteger value = Convert.toWei("1.0", Convert.Unit.ETHER).toBigInteger();
			RawTransaction rawTransaction  = RawTransaction.createEtherTransaction(getNonce("0xaab8bcded48300340cd54381b0be22d563f886c5"), web3j.ethGasPrice().send().getGasPrice(), BigInteger.valueOf(21000), "0x6e06dad5fc96607d216593ac78d5294e716efe80",value);
			byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
			String signedTransactionData = Numeric.toHexString(signedMessage);
			EthSendTransaction t = web3j.ethSendRawTransaction(signedTransactionData).sendAsync().get();
			Log.log("TransactionHash:" + t.getTransactionHash());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
