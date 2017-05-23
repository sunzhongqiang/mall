//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var goodsGrid;
    var treeGrid;
    var goodsId;
    $(function() {
        goodsGrid = $('#goodsGrid').datagrid({
        	 url : '/goods/goods/userCategoryGoods',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
            	 {
                     width : '80',
                     title : '商品名称',
                     field : 'title',
                 },
                 {
                     width : '80',
                     title : '商品价格',
                     field : 'price',
                 },
                 {
                     width : '80',
                     title : '商品数量',
                     field : 'num',
                 },
                 {
                     width : '80',
                     title : '商品编码',
                     field : 'code',
                 }
           ]],
           onSelect: function(index,row) {
        	   goodsId = row.id;
        	   treeGrid.tree('reload');
           }
           
        });
        
        leftTreeGrid  = $('#categoryLeftTree').tree({
            url : '/goods/category/gridData',
            fit : true,
            fitColumns: true,
            striped : true,
            singleSelect : true,
            idField : 'id',
            parentField:'parentId',
            textField : 'name',
            lines:true,//显示虚线效果  
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
           {
                width : '200',
                title : '资源名称',
                field : 'name',
            }] ],
            onSelect: function(row) {
            	goodsGrid.datagrid('load',{categoryId:row.id});
            }
        });
        
        loadGoodsCategory();
    });
    
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
    	goodsGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        goodsGrid.datagrid('load', {});
    }
    
    
    function loadGoodsCategory(){
    	treeGrid = $('#categoryTree').tree({
            url : '/goods/category/loadByGoodsId',
            fit : true,
            fitColumns: true,
            striped : true,
            singleSelect : true,
            idField : 'id',
            parentField:'parentId',
            textField : 'name',
            animate: true,  
            checkbox: true,  
            cascadeCheck:false,
            lines:true,//显示虚线效果  
            onCheck: function(row,checked) {
            	if(!goodsId){
            		alert("请选择商品");
            		return false;
            	}
            	
            	
            	$.ajax({
                    url: '/goods/goodsLinkCategory/link',
                   data:{goodsId:goodsId,categoryId:row.id,checked:checked},
                    success: function(result){
                        progressClose();
                    },
                    error: function(){
                        progressClose();
                        alert("系统错误");
                    }
                });
            },
            onBeforeLoad:function(node,param){
            	param.goodsId = goodsId;
            }
    	
        });
    }
    