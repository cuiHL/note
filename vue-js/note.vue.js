
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="./assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="./assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="./assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="./assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="./assets/global/plugins/zTree/css/zTreeStyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="./assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>
<link rel="stylesheet" href="./assets/global/plugins/codemirror/lib/codemirror.css">
<link rel="stylesheet" href="./assets/global/plugins/codemirror/theme/eclipse.css">
<link href="./assets/global/plugins/editor.md/css/editormd.css" rel="stylesheet" type="text/css"/>
<link href="./assets/global/plugins/editor.md/css/editormd.preview.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="./assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="./assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="./assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="./assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
<link href="./assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>学习笔记</title>

    <style type="text/css">
        th {text-align:center}
        .circle {border-radius:50%;width:50px;height:50px;text-align:center;vertical-align:middle;display:inline-block;line-height:50px;color:white;background-color:#ccc}
        .active .circle{color:rgb(51, 51, 51);background-color:#45b6af}
        
        .ztree li span.button.dir_ico_open{margin-right:2px; background-position:-110px -16px; vertical-align:top; *vertical-align:middle}
        .ztree li span.button.dir_ico_close{margin-right:2px; background-position:-110px 0; vertical-align:top; *vertical-align:middle}
        .ztree li span.button.dir_ico_docu{margin-right:2px; background-position:-110px 0; vertical-align:top; *vertical-align:middle}
        .ztree li span.button.doc_ico_docu{margin-right:2px; background-position:-110px -32px; vertical-align:top; *vertical-align:middle}
    </style>
    
</head>


<body class="page-header-fixed page-quick-sidebar-over-content page-style-square page-full-width">

    <div id="to-do-app">
        <!-- BEGIN HEADER -->
        <div class="page-header navbar navbar-fixed-top">
            <!-- BEGIN HEADER INNER -->
            <div class="page-header-inner">
                <!-- BEGIN LOGO -->
                <div class="page-logo">
                    <!--
                    <a href="index.html">
                    <img src="./assets/admin/layout/img/logo.png" alt="logo" class="logo-default"/>
                    </a>
                    -->
                    <img src="./img/logo150X45.png" alt="logo" class="logo-default"  style="margin-top:5px"/>
                    <span style="font-size:20px;color:white;margin-top:8px;display:block;position:relative;left:55px;top:-38px;font-family:Comic Sans MS;font-weight:bold">学习笔记</span>
                    <div class="menu-toggler sidebar-toggler hide">
                    </div>
                </div>
                <!-- END LOGO -->
                <!-- BEGIN HORIZANTAL MENU -->
                <!-- DOC: Remove "hor-menu-light" class to have a horizontal menu with theme background instead of white background -->
                <!-- DOC: This is desktop version of the horizontal menu. The mobile version is defined(duplicated) in the responsive menu below along with sidebar menu. So the horizontal menu has 2 seperate versions -->
                <div class="hor-menu hor-menu-light hidden-sm hidden-xs">
                    <!-- <?=$this->m_html->tree_to_nav1($system['systems'], $system['path']);?> -->
                </div>
                <!-- END HORIZANTAL MENU -->
                
                <!-- BEGIN RESPONSIVE MENU TOGGLER -->
                <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
                </a>
                <!-- END RESPONSIVE MENU TOGGLER -->
                
                <!-- BEGIN TOP NAVIGATION MENU -->
                <div class="top-menu">
                    <ul class="nav navbar-nav pull-right">
                        <!-- BEGIN USER LOGIN DROPDOWN -->
                        <!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
                        <li class="dropdown dropdown-user">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <!--<img alt="" class="img-circle" src="./assets/admin/layout/img/avatar3_small.jpg"/>-->
                            <span class="username username-hide-on-mobile">
                            <!-- <?=$_SESSION['user']['user_name']?>  -->
                            </span>
                            <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-default">
                                <li>
                                    <a href="">
                                    <i class="icon-key"></i>退出</a>
                                </li>
                            </ul>
                        </li>
                        <!-- END USER LOGIN DROPDOWN -->
                    </ul>
                </div>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END HEADER INNER -->
        </div>
        <!-- END HEADER --> 
    
    
        <div class="clearfix">
        <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <div class="page-content">
                        <!-- BEGIN PAGE CONTENT-->
                        <div class="row">
                            <div class="col-md-12 form-inline" style="margin-bottom:10px">
                                <div class="form-group">
                                    <label class="control-label">账号</label>
                                    <select class="form-control" style="width:200px" v-model="user.user_id" @change="change_user()">
                                        <!-- <option value="{{user.user_id}}" ng-repeat="user in users" ng-selected="user_id==user.user_id">{{user.name}}</option> -->
                                        <option value="user.user_id">{{ user.user_name }}</option>
                                    </select>
                                </div>
                                <button class="btn btn-warning" @click="create_note()" v-show="!has_note">创建我的笔记本</button>
                                <button class="btn btn-info" @click="search()" v-show="mode=='preview'">查找</button>
                                <div style="float:right">
                                <button class="btn btn-primary" @click="markdown()" v-show="mode=='preview' && can_edit && node_type==2">编辑</button>
                                <button class="btn btn-primary" @click="save()" v-show="mode=='edit'">保存</button>
                                <button class="btn btn-cancel" @click="cancel()" v-show="mode=='edit'">取消</button>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div style="width:300px;float:left;height:100%;padding-right:0" class="left-side">
                                    <ul id="tree" class="ztree" style="border:solid 1px #ccc;height:600px;overflow:scroll"></ul>
                                </div>
                                <div style="position:absolute;width:10px;height:100%;top:0;left:315px;cursor:ew-resize" id="resize_div"></div>
                                <div style="margin-left:310px;padding-left:0" class="right-side">
                                    <div id="editormd" v-show="mode=='edit'"></div>
                                    <div id="editormd-view" v-show="mode=='preview'" style="height:500px;border:solid 1px #ccc"></div>
                                </div>
    
                            </div>
                        </div>
                        <!-- END PAGE CONTENT-->
                    </div>
                </div>
                <!-- END CONTENT -->
            </div>
        </div>>
        <!-- END CONTAINER -->
    
        <!-- BEGIN FOOTER -->
        <div class="page-footer">
            <div class="page-footer-inner">
                Copyright&nbsp;&copy;1996&nbsp;-&nbsp;2013&nbsp;SINA&nbsp;Corporation,&nbsp;All&nbsp;Rights&nbsp;Reserved
            </div>
            <div class="scroll-to-top">
                <i class="icon-arrow-up"></i>
            </div>
        </div>
        <!-- END FOOTER -->
    
    
        <div class="form-group">
            <script type="text/ng-template" id="NodeModal.html">
                <div class="modal-header">
                    <h3 class="modal-title">节点</h3>
                </div>
                <div class="modal-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="名称" v-model="row.title">
                            </div>
                        </div>
                        <div class="form-group" v-show="!row.node_id">
                            <label for="name" class="col-sm-2 control-label">类型</label>
                            <div class="col-sm-10">

                                    <el-radio-group v-model="row.type">
                                      <el-radio :value="1">目录</el-radio>
                                      <el-radio :value="2">文档</el-radio>
                                    </el-radio-group>
                            
                                <!-- <label class="checkbox-inline"><input type="radio" name="type" value="1" v-model="row.type" ng-checked="row.type==1">目录</label> -->
                                <!-- <label class="checkbox-inline"><input type="radio" name="type" value="2" v-model="row.type" ng-checked="row.type==2">文档</label> -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" @click="ok()">确定</button>
                    <button class="btn btn-cancel" @click="cancel()">取消</button>
                </div>
            </script>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js">  </script>
    <script src="./assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
    <script src="./assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="./assets/global/plugins/bootbox/bootbox.min.js"></script>
    <!-- END CORE PLUGINS -->
    
    <!-- BEGIN CORE ANGULARJS PLUGINS -->
    <script src="./assets/global/plugins/angularjs/angular.min.js" type="text/javascript"></script>
    <script src="./assets/global/plugins/angularjs/plugins/ui-bootstrap-tpls.min.js" type="text/javascript"></script>
    <!-- END CORE ANGULARJS PLUGINS -->
    
    <script src="./assets/global/scripts/metronic.js" type="text/javascript"></script>
    <script src="./assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
    <script src="./assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
    <script src="./assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
    <script type="text/javascript" src="./assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
    <script src="./assets/global/plugins/zTree/js/jquery.ztree.all.min.js"></script>
    
    
    <script src="./assets/global/plugins/editor.md/lib/marked.min.js"></script>
    
    <script src="./assets/global/plugins/editor.md/lib/prettify.min.js"></script>
    
        
    <script src="./assets/global/plugins/editor.md/lib/raphael.min.js"></script>
    
    <script src="./assets/global/plugins/editor.md/lib/underscore.min.js"></script>
    
    <script src="./assets/global/plugins/editor.md/lib/sequence-diagram.min.js"></script>
    
    <script src="./assets/global/plugins/editor.md/lib/flowchart.min.js"></script>
    
    <script src="./assets/global/plugins/editor.md/lib/jquery.flowchart.min.js"></script>
    
    
    <script src="./assets/global/plugins/editor.md/editormd.js"></script>
    
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <script>

        function resize(){
            var height = document.documentElement.clientHeight;
            height -= 200;
            console.log(height);
            $('#tree').css('height', height);
            $('#editormd').css('height', height);
            $('#editormd-view').css('height', height);
        }
   

        $('#resize_div').mousedown(function(e){
            var offsetX = e.pageX;
            var offsetY = e.pageY;
            var w = $('.left-side').width();
            //var h = $('.tag-create').height();
            $(document).mousemove(function(e){
                var x = e.pageX - offsetX;
                var y = e.pageY - offsetY;
                var width = w + x;
                $('.left-side').css('width', width);
                $('.right-side').css('margin-left', (width+10)+'px');
                $('#resize_div').css('left', (width+15)+'px');
            });
            $(document).mouseup(function(){
                $(document).unbind('mousemove');
                $(document).unbind('mouseup');
            });
            return false;
        });


        jQuery(document).ready(function() {
            Metronic.init(); // init metronic core components
            Layout.init(); // init current layout
            QuickSidebar.init(); // init quick sidebar
            Demo.init(); // init demo features
            
            resize();
        });

        var app = new Vue({
            el : "#to-do-app",
            data : {
                user :  { user_name : "", user_id : "" },
                has_note : false, 
                mode : "preview",
                can_edit : false 
        
            },
            methods : {
                change_user : function() {
                    
                },

                get_user : function() {
                    // console.log(this.user.user_name)
                axios.get("http://localhost:8080/note/ztree/1")
                    .then(res=>{
                        console.log(res)
                        })
                        // window.location.replace("http://localhost:8080/login.html")

                }
            },

            mounted : function() {
                this.get_user()
            }
        
        })




    </script>


</body>