package edu.mum.dao;


import java.util.List;


import edu.mum.domain.Item;


public interface ItemDao extends GenericDao<Item> {
    Item findOne(Long itemId);
    List<Item> findItemByName(String itemName);
    void delete(Long id);
	List<Item> findItemByCategoryId(Long id);
}
