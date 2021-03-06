package org.jhblockchain.web3jtest;

import java.math.BigInteger;

import org.junit.Test;

import rx.Subscription;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Unit test for simple App.
 */
public class PendingTxObservableTest extends BaseTest {

	@Test
	public void testApp() {
		Subscription subscription = web3j.transactionObservable().subscribe(tx -> {
			System.out.println(JSON.toJSONString(tx, SerializerFeature.PrettyFormat));
		});

		Subscription subscription2 = web3j.pendingTransactionObservable().subscribe(tx -> {
			String blockHash = tx.getBlockHash();

			BigInteger blockNumber = null;
			try {
				blockNumber = tx.getBlockNumber();
			} catch (Exception e) {
			}
			String blockNumberRaw = tx.getBlockNumberRaw();
			Integer chainId = tx.getChainId();
			String creates = tx.getCreates();
			String from = tx.getFrom();
			BigInteger gas = null;
			try{
				gas = tx.getGas();
			}catch(Exception e){
			}
			BigInteger gasPrice = null;
			try{
				gasPrice = tx.getGasPrice();
			}catch(Exception e){
			}
			String gasPriceRaw = tx.getGasPriceRaw();
			String gasRaw = tx.getGasRaw();
			String hash = tx.getHash();
			String input = tx.getInput();
			BigInteger nonce = null;
			try{
				nonce = tx.getNonce();
			}catch(Exception e){
			}
			String nonceRaw = tx.getNonceRaw();
			String publicKey = tx.getPublicKey();
			String r = tx.getR();
			String raw = tx.getRaw();
			String s = tx.getS();
			String to = tx.getTo();

			BigInteger txIdx = null;
			try {
				txIdx = tx.getTransactionIndex();
			} catch (Exception e) {
			}
			String txIdxRaw = tx.getTransactionIndexRaw();
			int v = tx.getV();
			BigInteger value = null;
			try {
				value = tx.getValue();
			} catch (Exception e) {
			}
			String valueRaw = tx.getValueRaw();

			StringBuilder sb = new StringBuilder();
			sb.append("{\n");
			sb.append("blockHash:" + blockHash + "\n");
			sb.append("blockNumber:" + blockNumber + "\n");
			sb.append("blockNumberRaw:" + blockNumberRaw + "\n");
			sb.append("chainId:" + chainId + "\n");
			sb.append("creates:" + creates + "\n");
			sb.append("from:" + from + "\n");
			sb.append("gas:" + gas + "\n");
			sb.append("gasPrice:" + gasPrice + "\n");
			sb.append("gasPriceRaw:" + gasPriceRaw + "\n");
			sb.append("gasRaw:" + gasRaw + "\n");
			sb.append("hash:" + hash + "\n");
			sb.append("input:" + input + "\n");
			sb.append("nonce:" + nonce + "\n");
			sb.append("nonceRaw:" + nonceRaw + "\n");
			sb.append("publicKey:" + publicKey + "\n");
			sb.append("r:" + r + "\n");
			sb.append("raw:" + raw + "\n");
			sb.append("s:" + s + "\n");
			sb.append("to:" + to + "\n");
			sb.append("txIdx:" + txIdx + "\n");
			sb.append("txIdxRaw:" + txIdxRaw + "\n");
			sb.append("v:" + v + "\n");
			sb.append("value:" + value + "\n");
			sb.append("valueRaw" + valueRaw + "\n");
			sb.append("}\n");
			System.out.println(sb.toString());
		});
		pending();
		// subscription.unsubscribe();
	}
}
