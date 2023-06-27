package com.ezen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper<K,V> {
   public void insert(V v) throws Exception;
   public void delete(K k) throws Exception;
   public void update(V v) throws Exception;
   
   public V select(K k) throws Exception;
   public List<V> selectall() throws Exception;
}