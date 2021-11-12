package org.honglu.note.service;

    import com.alibaba.fastjson.JSONObject;
import org.honglu.note.mapper.ZTreeMapper;
import org.honglu.note.model.NodeContent;
import org.honglu.note.model.NodeField;
import org.honglu.note.model.NodeMove;
import org.honglu.note.model.NodeTreeWithIcon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZTreeService {
    @Autowired
    ZTreeMapper ztreeMapper;
    public List<NodeTreeWithIcon> getTree(String username) {
        return ztreeMapper.getTree(username);
    }

    public NodeField getNode(Integer node_id) {
        return ztreeMapper.getNode(node_id);
    }


    public String saveNode(NodeField nodeField) {
        if (nodeField.getId() == null) {
            Integer sort = 999;
            ztreeMapper.insertNode(nodeField);

            int node_id = ztreeMapper.getNewNode(nodeField);

            System.out.println(node_id);

            if (nodeField.getType() == 2) {
                //文档;
                ztreeMapper.insertNodeContent(nodeField.getId());
            }

            nodeField.setId(node_id);

            ztreeMapper.resortTree(nodeField.getpId());

        } else {
            ztreeMapper.updateTitle(nodeField);
        }

        JSONObject result = new JSONObject();
        try {
            result.put("id", nodeField.getId());
            result.put("pId", nodeField.getpId());
            result.put("title", nodeField.getTitle());
            result.put("type", nodeField.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toJSONString();
    }

    public String delNode(Integer node_id) {
        Integer childCount = ztreeMapper.getChildCount(node_id);
        if (childCount > 0) {
            JSONObject result = new JSONObject();
            result.put("code", 1);
            result.put("desc", "请先删除子节点");
            return result.toJSONString();
        }

        ztreeMapper.delNode(node_id);
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("desc", 1);
        return result.toJSONString();
    }

    public String moveNode(Integer node_id1, Integer node_id2, String move_type) {
        NodeField nodeField = getNode(node_id2);

        Integer pId;
        Integer sort;

        if (move_type == "inner") {
            pId = node_id2;
            sort = 999;
        } else {
            sort = nodeField.getSort();
            pId = nodeField.getpId();

            if (move_type == "prev") {
                sort = sort - 1;
            } else {
                sort = sort + 1;
            }
        }

        ztreeMapper.updatePId(new NodeMove(node_id1, pId, sort));

        ztreeMapper.resortTree(pId);

        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("desc", 1);
        return result.toJSONString();
    }

    public NodeContent getContent(Integer node_id) {
        NodeContent nodeContent = new NodeContent();
        if(ztreeMapper.getContent(node_id) != null) {
            return ztreeMapper.getContent(node_id);
        };
        return nodeContent;
    }

    public String saveContent(NodeContent nodeContent) {
        ztreeMapper.saveContent(nodeContent);

        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("desc", 1);
        return result.toJSONString();
    }

    public String getUser() {
        JSONObject result = new JSONObject();
        result.put("code", 0);
        result.put("user", "honglu");
        result.put("user_id", "1");
        return result.toJSONString();
    }

}
