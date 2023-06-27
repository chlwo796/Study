package com.ezen.service;

import java.util.List;

public interface MemberService<K, V> {
	public void register(V v) throws Exception; // insert

	public void remove(K k) throws Exception; // delete

	public void modify(V v) throws Exception; // update

	public V get(K k) throws Exception; // select

	public List<V> get() throws Exception; // selectall
}