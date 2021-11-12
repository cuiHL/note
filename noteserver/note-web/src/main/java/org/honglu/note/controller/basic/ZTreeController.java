package org.honglu.note.controller.basic;

import org.honglu.note.model.NodeContent;
import org.honglu.note.model.NodeField;
import org.honglu.note.model.NodeTreeWithIcon;
import org.honglu.note.service.ZTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/note/ztree")
public class ZTreeController {
    @Autowired
    ZTreeService zTreeService;
    @CrossOrigin
    @GetMapping("/user/{username}")
    public List<NodeTreeWithIcon> getTree(@PathVariable String username) {
        return zTreeService.getTree(username);
    }

    @GetMapping("/node/{node_id}")
    public NodeField getNode(@PathVariable Integer node_id) {
        return zTreeService.getNode(node_id);
    }

    @PostMapping("/savenode")
    public String saveNode(@RequestBody NodeField nodeField) {
        return zTreeService.saveNode(nodeField);
    }

    @GetMapping("/delnode/{node_id}")
    public String delNode(@PathVariable Integer node_id) {
        return zTreeService.delNode(node_id);
    }

    @GetMapping("/movenode")
    public String moveNode(Integer node_id1, Integer node_id2, String move_type) {return zTreeService.moveNode(node_id1, node_id2, move_type);}

    @GetMapping("/getcontent/{node_id}")
    public NodeContent getContent(@PathVariable Integer node_id) {return zTreeService.getContent(node_id);}

    @PostMapping("/savecontent")
    public String saveContent(@RequestBody NodeContent nodeContent) {return zTreeService.saveContent(nodeContent);}

    @GetMapping("/getuser")
    public String getUser() {return zTreeService.getUser();}
}
