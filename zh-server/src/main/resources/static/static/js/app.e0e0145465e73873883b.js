webpackJsonp([1],{"+Td1":function(e,t){},"/FwE":function(e,t){},"5FSp":function(e,t){},E5ZW:function(e,t){},LtzE:function(e,t){},NHnr:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=r("7+uW"),o={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var a=r("VU/8")({name:"App"},o,!1,function(e){r("LtzE")},null,null).exports,s=r("/ocq"),i={name:"Register",data:function(){var e=this;return{registerForm:{lUsername:"",lPassword:"",newPassword:""},rules2:{lUsername:[{required:!0,message:"请输入用户名",trigger:"blur"}],lPassword:[{required:!0,message:"请输入密码",trigger:"blur"},{validator:function(t,r,n){""===r?n(new Error("请输入密码")):(""!==e.registerForm.lPassword&&e.$refs.registerForm.validateField("password"),n())},trigger:blur}],newPassword:[{required:!0,message:"请输入确认密码",trigger:"blur"},{validator:function(t,r,n){""===r?n(new Error("请再次输入密码")):r!==e.registerForm.lPassword?n(new Error("两次输入密码不一致!")):n()},trigger:blur}]},checked:!0,loading:!1}},methods:{register:function(e){var t=this;this.$refs[e].validate(function(e){e?t.$axios.post("/register",{username:t.registerForm.lUsername,password:t.registerForm.lPassword}).then(function(e){200===e.code?(t.$message({message:"注册成功",type:"success",duration:1e3}),t.$router.go(0)):t.$message.error(e.data.msg)}):t.$message.error("请填写信息")})}}},l={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("el-form",{ref:"registerForm",staticClass:"login-container",attrs:{model:e.registerForm,rules:e.rules2}},[r("h3",{staticClass:"login-title"},[e._v("用户注册")]),e._v(" "),r("el-form-item",{attrs:{prop:"lUsername"}},[r("el-input",{attrs:{placeholder:"请填写用户名"},model:{value:e.registerForm.lUsername,callback:function(t){e.$set(e.registerForm,"lUsername",t)},expression:"registerForm.lUsername"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"lPassword"}},[r("el-input",{attrs:{type:"password",placeholder:"请填写密码"},model:{value:e.registerForm.lPassword,callback:function(t){e.$set(e.registerForm,"lPassword",t)},expression:"registerForm.lPassword"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"newPassword"}},[r("el-input",{attrs:{type:"password",placeholder:"请再次填写密码"},model:{value:e.registerForm.newPassword,callback:function(t){e.$set(e.registerForm,"newPassword",t)},expression:"registerForm.newPassword"}})],1),e._v(" "),r("el-form-item",{staticStyle:{width:"100%"}},[r("el-button",{staticStyle:{width:"100%",border:"none"},attrs:{type:"primary"},on:{click:function(t){return e.register("registerForm")},keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.register(t)}}},[e._v("注册")])],1)],1)},staticRenderFns:[]};var m=r("VU/8")(i,l,!1,function(e){r("+Td1")},"data-v-316fa64c",null).exports,u={name:"Login",components:{Register:m},data:function(){return{loginForm:{username:"",password:"",rememberMe:!1},rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]},checked:!0,loading:!1,activeName:"login"}},methods:{login:function(e){var t=this,r=this;this.$refs[e].validate(function(e){e?t.$axios.post("/login",{username:t.loginForm.username,password:t.loginForm.password}).then(function(e){if(console.log(t.loginForm.rememberMe),200===e.data.code){r.$message({message:"登录成功",type:"success",duration:1e3});var n=e.data.data;r.$store.commit("login",n);var o=t.$route.query.redirect;r.$router.replace({path:"/"===o||void 0===o?"/index":o})}else t.$message.error(e.data.msg)}).catch(function(e){}):t.$message.error("请填写用户名密码")})},handleClick:function(e,t){console.log(e,t)}}},c={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("body",{attrs:{id:"poster"}},[r("el-tabs",{staticClass:"container",on:{"tab-click":e.handleClick},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[r("el-tab-pane",{attrs:{label:"登录",name:"login"}},[r("el-form",{ref:"loginForm",staticClass:"login-container",attrs:{model:e.loginForm,rules:e.rules}},[r("h3",{staticClass:"login-title"},[e._v("登录界面")]),e._v(" "),r("el-form-item",{attrs:{prop:"username"}},[r("el-input",{attrs:{placeholder:"请输入用户名"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"password"}},[r("el-input",{attrs:{type:"password",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),e._v(" "),r("el-form-item",{attrs:{prop:"rememberMe"}},[r("el-checkbox",{staticStyle:{color:"white"},model:{value:e.loginForm.rememberMe,callback:function(t){e.$set(e.loginForm,"rememberMe",t)},expression:"loginForm.rememberMe"}},[e._v("记住我")])],1),e._v(" "),r("el-form-item",{staticStyle:{width:"100%"}},[r("el-button",{staticStyle:{width:"100%",border:"none"},attrs:{type:"primary"},on:{click:function(t){return e.login("loginForm")},keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.login(t)}}},[e._v("登  录")])],1)],1)],1),e._v(" "),r("el-tab-pane",{attrs:{label:"注册",name:"register"}},[r("Register")],1)],1)],1)},staticRenderFns:[]};var d=r("VU/8")(u,c,!1,function(e){r("E5ZW")},"data-v-3a1f29be",null).exports,p={render:function(){var e=this.$createElement;return(this._self._c||e)("h3",[this._v("hello welcome")])},staticRenderFns:[]};var g=r("VU/8")({name:"Appindex"},p,!1,function(e){r("/FwE")},"data-v-15921854",null).exports,f={name:"NavMenu",data:function(){return{navList:[{name:"/index",navItem:"首页"},{name:"/jotter",navItem:"java"},{name:"/library",navItem:"数据库"},{name:"/admin",navItem:"中间件"}],uName:JSON.parse(localStorage.getItem("user")).username}},created:function(){},methods:{logout:function(){var e=this;this.$confirm("确定要退出吗?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){e.$axios.post("/logout").then(function(t){console.log(t),e.$message(t.data.msg)})})}}},v={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("el-menu",{staticStyle:{"min-width":"1500px"},attrs:{"default-active":"/index",router:"",mode:"horizontal","background-color":"white","text-color":"#222","active-text-color":"red"}},[e._l(e.navList,function(t,n){return r("el-menu-item",{key:n,attrs:{index:t.name}},[e._v("\n    "+e._s(t.navItem)+"\n    "),e._l(t.children,function(n,o){return null!=t.children?r("el-submenu",{key:o,attrs:{index:n.name}},[r("el-menu-item",[e._v(e._s(n.navItem))])],1):e._e()})],2)}),e._v(" "),r("span",{staticStyle:{position:"absolute","padding-top":"20px",right:"38%","font-size":"20px","font-weight":"bold"}},[e._v("Welcome to Dz-blogs")]),e._v(" "),r("el-input",{staticStyle:{width:"300px",position:"absolute","margin-top":"12px",right:"18%"},attrs:{placeholder:"快速搜索...","prefix-icon":"el-icon-search",size:"medium"}}),e._v(" "),r("i",{staticClass:"el-icon-menu",staticStyle:{float:"right","font-size":"25px",color:"#222","padding-top":"8px"}}),e._v(" "),r("el-dropdown",{staticStyle:{float:"right","padding-top":"8px",color:"black"}},[r("span",{staticClass:"el-dropdown-link",domProps:{innerHTML:e._s(e.uName)}},[r("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),e._v(" "),r("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[r("el-dropdown-item",[e._v("个人中心")]),e._v(" "),r("el-dropdown-item",[e._v("修改密码")]),e._v(" "),r("el-dropdown-item",[e._v("退出")])],1)],1)],2)},staticRenderFns:[]};var w={name:"Home",components:{NavMenu:r("VU/8")(f,v,!1,function(e){r("lEgD")},"data-v-3f7ba28c",null).exports}},h={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("nav-menu"),this._v(" "),t("router-view")],1)},staticRenderFns:[]};var _=r("VU/8")(w,h,!1,function(e){r("5FSp")},"data-v-a995fe58",null).exports;n.default.use(s.a);var b=new s.a({mode:"hash",routes:[{path:"/",redirect:"/login",name:"init"},{path:"/login",name:"login",component:d},{path:"/register",name:"register",component:m},{path:"/home",name:"Home",component:_,children:[{path:"/index",name:"Appindex",component:g,meta:{requireAuth:!0}}]}]}),F=r("zL8q"),x=r.n(F),y=(r("tvR6"),r("mvHQ")),k=r.n(y),$=r("NYxO");n.default.use($.a);var S=new $.a.Store({state:{user:{name:null==window.localStorage.getItem("user")?"未登录":JSON.parse(window.localStorage.getItem("user")).name,username:null==window.localStorage.getItem("user")?"":JSON.parse(window.localStorage.getItem("user")).username}},mutations:{login:function(e,t){e.user=t,window.localStorage.setItem("user",k()(t))},logout:function(e){e.user=[],window.localStorage.removeItem("user")}}}),E=r("mtWM");E.defaults.baseURL="http://47.100.79.204/api",n.default.prototype.$axios=E,n.default.config.productionTip=!1,n.default.use(x.a),b.beforeEach(function(e,t,r){e.meta.requireAuth?S.state.user.username?r():r({path:"login",query:{redirect:e.fullPath}}):r()}),new n.default({el:"#app",render:function(e){return e(a)},router:b,store:S,components:{App:a},template:"<App/>"})},lEgD:function(e,t){},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.e0e0145465e73873883b.js.map