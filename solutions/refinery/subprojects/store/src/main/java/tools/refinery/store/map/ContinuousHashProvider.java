/*
 * SPDX-FileCopyrightText: 2021-2023 The Refinery Authors <https://refinery.tools/>
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package tools.refinery.store.map;

import tools.refinery.store.map.internal.state.Node;

/**
 * A class representing an equivalence relation for a type {@code K} with a
 * continuous hash function.
 *
 * @author Oszkar Semerath
 *
 * @param <K> Target java type.
 */
public interface ContinuousHashProvider<K> {
	public static final int EFFECTIVE_BITS = Node.EFFECTIVE_BITS;
	public static final int EFFECTIVE_BIT_MASK = (1 << (EFFECTIVE_BITS)) - 1;

	/**
	 * Maximal practical depth for differentiating keys. If two keys have the same
	 * hash code until that depth, the algorithm can stop.
	 */
	public static final int MAX_PRACTICAL_DEPTH = 500;

	/**
	 * Provides a hash code for a object {@code key} with a given {@code index}. It
	 * has the following contracts:
	 * <ul>
	 * <li>If {@link #equals}{@code (key1,key2)}, then
	 * {@code getHash(key1, index) == getHash(key2, index)} for all values of
	 * {@code index}.</li>
	 * <li>If {@code getHash(key1,index) == getHash(key2, index)} for all values of
	 * {@code index}, then {@link #equals}{@code (key1, key2)}</li>
	 * <li>In current implementation, we use only the least significant
	 * {@link #EFFECTIVE_BITS}
	 * </ul>
	 * Check {@link #equals} for further details.
	 *
	 * @param key   The target data object.
	 * @param index The depth of the hash code. Needs to be non-negative.
	 * @return A hash code.
	 */
	public int getHash(K key, int index);

	public default int getEffectiveHash(K key, int index) {
		return getHash(key, index) & EFFECTIVE_BIT_MASK;
	}

	public default int compare(K key1, K key2) {
		if (key1.equals(key2)) {
			return 0;
		} else {
			for (int i = 0; i < ContinuousHashProvider.MAX_PRACTICAL_DEPTH; i++) {
				int hash1 = getEffectiveHash(key1, i);
				int hash2 = getEffectiveHash(key2, i);
				for(int j = 0; j<Integer.SIZE/Node.BRANCHING_FACTOR_BITS; j++) {
					final int factorMask = (1<<Node.BRANCHING_FACTOR_BITS)-1;
					int hashFragment1 = (hash1>>>j*Node.BRANCHING_FACTOR_BITS) & factorMask;
					int hashFragment2 = (hash2>>>j*Node.BRANCHING_FACTOR_BITS) & factorMask;
					var result = Integer.compare(hashFragment1, hashFragment2);
					if (result != 0) {
						return result;
					}
				}
			}
			throw new IllegalArgumentException("Two different keys (" + key1 + " and " + key2
					+ ") have the same hashcode over the practical depth limitation ("
					+ ContinuousHashProvider.MAX_PRACTICAL_DEPTH + ")!");
		}
	}
}
