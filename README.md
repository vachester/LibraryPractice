###LibraryPractice 1.0
`提交名为“first commit”`
####主要框架和开发环境
* Eclipse,Struts2,java,jsp,html,mysql,javascript
* `MVC框架`

####数据库内容
* 数据库名称为BookDB;
* 里面插入了两个表：
	* Author(AuthorID int auto\_increment,
			Name varchar(100) not null,
			Age varchar(100) not null,
			Country varchar(100) not null);
	* Book	(ISBN char(13),
			Title varchar(100) not null,
			AuthorID varchar(100) not null,
			Publisher varchar(100) not null,
			PublishDate varchar(100) not null,
			Price varchar(100) not null);
* 在Author表中`PK`是__AuthorID__，Book中为__ISBN__，且Book中的__AuthorID__设置为`FK`并且以Author的AuthorID为参考

####实现功能
* 查询功能：输入作者名字，可以搜索到该作者存在数据库的所有图书;
* 参考功能：可以查看数据库已经存在的所有书籍;
* 删除功能：用户可以任意删除一本书籍;
* 查看功能：点击书名，可以查看该书的所有信息;
* 添加功能：用户可以按格式添加一本书籍;
* 编辑功能：用户可以编辑一本已经存在的书籍的某些信息。
