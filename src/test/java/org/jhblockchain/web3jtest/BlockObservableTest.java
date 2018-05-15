package org.jhblockchain.web3jtest;

import org.junit.Test;
import org.web3j.protocol.core.methods.response.EthBlock.Block;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import rx.Subscription;


/**
 * Unit test for simple App.
 */
public class BlockObservableTest extends BaseTest {

	@Test
	public void testApp() {
		Subscription subscription = web3j.blockObservable(false).subscribe(block -> {
			Block b = block.getBlock();
			System.out.println(JSON.toJSONString(b, SerializerFeature.PrettyFormat));
		});
		pending();
	}
}
