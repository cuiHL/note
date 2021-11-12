package org.honglu.note.mapper;


import org.honglu.note.model.NodeContent;
import org.honglu.note.model.NodeField;
import org.honglu.note.model.NodeMove;
import org.honglu.note.model.NodeTreeWithIcon;

import java.util.List;

public interface ZTreeMapper {
     List<NodeTreeWithIcon> getTree(String username);

     NodeField getNode(Integer node_id);

     void delNode(Integer node_id);

     void insertNode(NodeField insertNode);

     Integer getNewNode(NodeField insertNode);

     void insertNodeContent(Integer id);

     void resortTree(Integer pId);

     void updateTitle(NodeField nodeField);

     Integer getChildCount(Integer id);

     void updatePId(NodeMove nodeMove);

     NodeContent getContent(Integer id);

     void saveContent(NodeContent nodeContent);
}

