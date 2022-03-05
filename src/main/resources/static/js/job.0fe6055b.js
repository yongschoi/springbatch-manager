(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["job"],{"17b3":function(t,e,i){},"1f4f":function(t,e,i){"use strict";i("a9e3");var a=i("5530"),n=(i("8b37"),i("80d2")),s=i("7560"),r=i("58df");e["a"]=Object(r["a"])(s["a"]).extend({name:"v-simple-table",props:{dense:Boolean,fixedHeader:Boolean,height:[Number,String]},computed:{classes:function(){return Object(a["a"])({"v-data-table--dense":this.dense,"v-data-table--fixed-height":!!this.height&&!this.fixedHeader,"v-data-table--fixed-header":this.fixedHeader,"v-data-table--has-top":!!this.$slots.top,"v-data-table--has-bottom":!!this.$slots.bottom},this.themeClasses)}},methods:{genWrapper:function(){return this.$slots.wrapper||this.$createElement("div",{staticClass:"v-data-table__wrapper",style:{height:Object(n["f"])(this.height)}},[this.$createElement("table",this.$slots.default)])}},render:function(t){return t("div",{staticClass:"v-data-table",class:this.classes},[this.$slots.top,this.genWrapper(),this.$slots.bottom])}})},"20f6":function(t,e,i){},"8b37":function(t,e,i){},a523:function(t,e,i){"use strict";i("99af"),i("4de4"),i("b64b"),i("2ca0"),i("20f6"),i("4b85"),i("a15b"),i("498a");var a=i("2b0e");function n(t){return a["a"].extend({name:"v-".concat(t),functional:!0,props:{id:String,tag:{type:String,default:"div"}},render:function(e,i){var a=i.props,n=i.data,s=i.children;n.staticClass="".concat(t," ").concat(n.staticClass||"").trim();var r=n.attrs;if(r){n.attrs={};var o=Object.keys(r).filter((function(t){if("slot"===t)return!1;var e=r[t];return t.startsWith("data-")?(n.attrs[t]=e,!1):e||"string"===typeof e}));o.length&&(n.staticClass+=" ".concat(o.join(" ")))}return a.id&&(n.domProps=n.domProps||{},n.domProps.id=a.id),e(a.tag,n,s)}})}var s=i("d9f7");e["a"]=n("container").extend({name:"v-container",functional:!0,props:{id:String,tag:{type:String,default:"div"},fluid:{type:Boolean,default:!1}},render:function(t,e){var i,a=e.props,n=e.data,r=e.children,o=n.attrs;return o&&(n.attrs={},i=Object.keys(o).filter((function(t){if("slot"===t)return!1;var e=o[t];return t.startsWith("data-")?(n.attrs[t]=e,!1):e||"string"===typeof e}))),a.id&&(n.domProps=n.domProps||{},n.domProps.id=a.id),t(a.tag,Object(s["a"])(n,{staticClass:"container",class:Array({"container--fluid":a.fluid}).concat(i||[])}),r)}})},de2c:function(t,e,i){"use strict";i.d(e,"a",(function(){return r}));var a=i("90a2"),n=i("d9bd"),s=i("2b0e");function r(t){return"undefined"!==typeof window&&"IntersectionObserver"in window?s["a"].extend({name:"intersectable",mounted:function(){a["a"].inserted(this.$el,{name:"intersect",value:this.onObserve})},destroyed:function(){a["a"].unbind(this.$el)},methods:{onObserve:function(e,i,a){if(a)for(var s=0,r=t.onVisible.length;s<r;s++){var o=this[t.onVisible[s]];"function"!==typeof o?Object(n["c"])(t.onVisible[s]+" method is not available on the instance but referenced in intersectable mixin options"):o()}}}}):s["a"].extend({name:"intersectable"})}},e658:function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",[i("v-simple-table",{scopedSlots:t._u([{key:"default",fn:function(){return[i("thead",[i("tr",{attrs:{bgcolor:"lightgrey"}},[i("th",{staticClass:"text-center"},[t._v("Job ID")]),i("th",{staticClass:"text-center"},[t._v("Job Name")]),i("th",{staticClass:"text-center"},[t._v("Parameters")]),i("th",{staticClass:"text-center"},[t._v("Start Time")]),i("th",{staticClass:"text-center"},[t._v("End Time")]),i("th",{staticClass:"text-center"},[t._v("Exit Code")])])]),i("tbody",t._l(t.jobs,(function(e){return i("tr",{key:e.id},[i("td",{staticClass:"text-center"},[t._v(t._s(e.instanceId))]),i("td",{staticClass:"text-left"},[t._v(t._s(e.name))]),i("td",{staticClass:"text-right"},[t._v(t._s(e.params))]),i("td",{staticClass:"text-center"},[t._v(t._s(e.execution.startTime))]),i("td",{staticClass:"text-center"},[t._v(t._s(e.execution.endTime))]),"FAILED"==e.execution.exitCode||"STOPPED"==e.execution.exitCode||"UNKNOWN"==e.execution.exitCode?i("td",{staticClass:"text-center"},[i("v-badge",{attrs:{color:"error",icon:"mdi-bell",left:"",overlap:""}},[i("v-btn",{attrs:{text:"",small:"",color:"red"},on:{click:function(i){return t.viewStep(e)}}},[t._v(t._s(e.execution.exitCode)+" ")])],1)],1):i("td",{staticClass:"text-center"},[i("v-btn",{attrs:{text:"",small:""},on:{click:function(i){return t.viewStep(e)}}},[t._v(t._s(e.execution.exitCode)+" ")])],1)])})),0)]},proxy:!0}])}),i("div",{staticClass:"text-center"},[i("v-pagination",{attrs:{length:t.numOfPage,"total-visible":10},on:{input:function(e){return t.findByAll(t.page-1)}},model:{value:t.page,callback:function(e){t.page=e},expression:"page"}})],1)],1)},n=[],s=(i("99af"),i("bc3a")),r=i.n(s),o={data:function(){return{jobs:[],pageSize:10,numOfPage:0,page:1}},created:function(){this.findByAll(this.page-1)},methods:{findByAll:function(t){var e=this;r.a.get("/job/all?page=".concat(t,"&size=").concat(this.pageSize)).then((function(t){e.jobs=t.data.content,e.numOfPage=Math.ceil(t.data.totalElements/e.pageSize)})).catch((function(t){console.error(t)}))},viewStep:function(t){this.$router.push({name:"step",params:t.execution})}}},l=o,c=i("2877"),u=i("6544"),h=i.n(u),d=(i("a9e3"),i("15fd")),f=i("5530"),p=(i("ff44"),i("132d")),v=i("a9ad"),g=i("7560"),b=i("f2e7"),m=i("2b0e"),x=m["a"].extend({name:"transitionable",props:{mode:String,origin:String,transition:String}}),y=i("fe6c"),$=i("58df"),_=i("80d2"),C=Object($["a"])(v["a"],Object(y["b"])(["left","bottom"]),g["a"],b["a"],x).extend({name:"v-badge",props:{avatar:Boolean,bordered:Boolean,color:{type:String,default:"primary"},content:{required:!1},dot:Boolean,label:{type:String,default:"$vuetify.badge"},icon:String,inline:Boolean,offsetX:[Number,String],offsetY:[Number,String],overlap:Boolean,tile:Boolean,transition:{type:String,default:"scale-rotate-transition"},value:{default:!0}},computed:{classes:function(){return Object(f["a"])({"v-badge--avatar":this.avatar,"v-badge--bordered":this.bordered,"v-badge--bottom":this.bottom,"v-badge--dot":this.dot,"v-badge--icon":null!=this.icon,"v-badge--inline":this.inline,"v-badge--left":this.left,"v-badge--overlap":this.overlap,"v-badge--tile":this.tile},this.themeClasses)},computedBottom:function(){return this.bottom?"auto":this.computedYOffset},computedLeft:function(){return this.isRtl?this.left?this.computedXOffset:"auto":this.left?"auto":this.computedXOffset},computedRight:function(){return this.isRtl?this.left?"auto":this.computedXOffset:this.left?this.computedXOffset:"auto"},computedTop:function(){return this.bottom?this.computedYOffset:"auto"},computedXOffset:function(){return this.calcPosition(this.offsetX)},computedYOffset:function(){return this.calcPosition(this.offsetY)},isRtl:function(){return this.$vuetify.rtl},offset:function(){return this.overlap?this.dot?8:12:this.dot?2:4},styles:function(){return this.inline?{}:{bottom:this.computedBottom,left:this.computedLeft,right:this.computedRight,top:this.computedTop}}},methods:{calcPosition:function(t){return"calc(100% - ".concat(Object(_["f"])(t||this.offset),")")},genBadge:function(){var t=this.$vuetify.lang,e=this.$attrs["aria-label"]||t.t(this.label),i=this.setBackgroundColor(this.color,{staticClass:"v-badge__badge",style:this.styles,attrs:{"aria-atomic":this.$attrs["aria-atomic"]||"true","aria-label":e,"aria-live":this.$attrs["aria-live"]||"polite",title:this.$attrs.title,role:this.$attrs.role||"status"},directives:[{name:"show",value:this.isActive}]}),a=this.$createElement("span",i,[this.genBadgeContent()]);return this.transition?this.$createElement("transition",{props:{name:this.transition,origin:this.origin,mode:this.mode}},[a]):a},genBadgeContent:function(){if(!this.dot){var t=Object(_["l"])(this,"badge");return t||(this.content?String(this.content):this.icon?this.$createElement(p["a"],this.icon):void 0)}},genBadgeWrapper:function(){return this.$createElement("span",{staticClass:"v-badge__wrapper"},[this.genBadge()])}},render:function(t){var e=[this.genBadgeWrapper()],i=[Object(_["l"])(this)],a=this.$attrs,n=(a["aria-atomic"],a["aria-label"],a["aria-live"],a.role,a.title,Object(d["a"])(a,["aria-atomic","aria-label","aria-live","role","title"]));return this.inline&&this.left?i.unshift(e):i.push(e),t("span",{staticClass:"v-badge",attrs:n,class:this.classes},i)}}),O=i("8336"),S=i("a523"),j=(i("d81d"),i("d3b7"),i("25f0"),i("2909")),B=(i("17b3"),i("9d26")),w=i("dc22"),L=i("de2c"),P=Object($["a"])(v["a"],Object(L["a"])({onVisible:["init"]}),g["a"]).extend({name:"v-pagination",directives:{Resize:w["a"]},props:{circle:Boolean,disabled:Boolean,length:{type:Number,default:0,validator:function(t){return t%1===0}},nextIcon:{type:String,default:"$next"},prevIcon:{type:String,default:"$prev"},totalVisible:[Number,String],value:{type:Number,default:0},pageAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.page"},currentPageAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.currentPage"},previousAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.previous"},nextAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.next"},wrapperAriaLabel:{type:String,default:"$vuetify.pagination.ariaLabel.wrapper"}},data:function(){return{maxButtons:0,selected:null}},computed:{classes:function(){return Object(f["a"])({"v-pagination":!0,"v-pagination--circle":this.circle,"v-pagination--disabled":this.disabled},this.themeClasses)},items:function(){var t=parseInt(this.totalVisible,10);if(0===t)return[];var e=Math.min(Math.max(0,t)||this.length,Math.max(0,this.maxButtons)||this.length,this.length);if(this.length<=e)return this.range(1,this.length);var i=e%2===0?1:0,a=Math.floor(e/2),n=this.length-a+1+i;if(this.value>a&&this.value<n){var s=this.value-a+2,r=this.value+a-2-i;return[1,"..."].concat(Object(j["a"])(this.range(s,r)),["...",this.length])}if(this.value===a){var o=this.value+a-1-i;return[].concat(Object(j["a"])(this.range(1,o)),["...",this.length])}if(this.value===n){var l=this.value-a+1;return[1,"..."].concat(Object(j["a"])(this.range(l,this.length)))}return[].concat(Object(j["a"])(this.range(1,a)),["..."],Object(j["a"])(this.range(n,this.length)))}},watch:{value:function(){this.init()}},mounted:function(){this.init()},methods:{init:function(){var t=this;this.selected=null,this.$nextTick(this.onResize),setTimeout((function(){return t.selected=t.value}),100)},onResize:function(){var t=this.$el&&this.$el.parentElement?this.$el.parentElement.clientWidth:window.innerWidth;this.maxButtons=Math.floor((t-96)/42)},next:function(t){t.preventDefault(),this.$emit("input",this.value+1),this.$emit("next")},previous:function(t){t.preventDefault(),this.$emit("input",this.value-1),this.$emit("previous")},range:function(t,e){var i=[];t=t>0?t:1;for(var a=t;a<=e;a++)i.push(a);return i},genIcon:function(t,e,i,a,n){return t("li",[t("button",{staticClass:"v-pagination__navigation",class:{"v-pagination__navigation--disabled":i},attrs:{type:"button","aria-label":n},on:i?{}:{click:a}},[t(B["a"],[e])])])},genItem:function(t,e){var i=this,a=e===this.value&&(this.color||"primary"),n=e===this.value,s=n?this.currentPageAriaLabel:this.pageAriaLabel;return t("button",this.setBackgroundColor(a,{staticClass:"v-pagination__item",class:{"v-pagination__item--active":e===this.value},attrs:{type:"button","aria-current":n,"aria-label":this.$vuetify.lang.t(s,e)},on:{click:function(){return i.$emit("input",e)}}}),[e.toString()])},genItems:function(t){var e=this;return this.items.map((function(i,a){return t("li",{key:a},[isNaN(Number(i))?t("span",{class:"v-pagination__more"},[i.toString()]):e.genItem(t,i)])}))},genList:function(t,e){return t("ul",{directives:[{modifiers:{quiet:!0},name:"resize",value:this.onResize}],class:this.classes},e)}},render:function(t){var e=[this.genIcon(t,this.$vuetify.rtl?this.nextIcon:this.prevIcon,this.value<=1,this.previous,this.$vuetify.lang.t(this.previousAriaLabel)),this.genItems(t),this.genIcon(t,this.$vuetify.rtl?this.prevIcon:this.nextIcon,this.value>=this.length,this.next,this.$vuetify.lang.t(this.nextAriaLabel))];return t("nav",{attrs:{role:"navigation","aria-label":this.$vuetify.lang.t(this.wrapperAriaLabel)}},[this.genList(t,e)])}}),I=i("1f4f"),A=Object(c["a"])(l,a,n,!1,null,null,null);e["default"]=A.exports;h()(A,{VBadge:C,VBtn:O["a"],VContainer:S["a"],VPagination:P,VSimpleTable:I["a"]})},ff44:function(t,e,i){}}]);
//# sourceMappingURL=job.0fe6055b.js.map