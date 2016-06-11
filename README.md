# Blog
> springmvc+mybatis+maven+mysql搭建博客
数据库设计图：
![image](https://github.com/scau-beyondboy/Blog/blob/master/2016-06-12_001056.png)
```
{
	"variables": [],
	"info": {
		"name": "blog",
		"_postman_id": "e57bffaa-a445-69bc-aeeb-ad5e8dbd072e",
		"description": "",
		"schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json"
	},
	"item": [
		{
			"name": "http://localhost:8080/blog/user/query",
			"request": {
				"url": "http://localhost:8080/blog/user/query",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"id\":1\n}"
				},
				"description": "查找用户请求接口"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/user/login",
			"request": {
				"url": "http://localhost:8080/blog/user/login",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"username\":\"beyondboy\",\n    \"password\":\"123456\"\n}"
				},
				"description": "用户登录请求接口"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/user/register",
			"request": {
				"url": "http://localhost:8080/blog/user/register",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"username\": \"sungirl\",\n    \"birthday\": \"2016-05-12\",\n    \"sex\": \"man\",\n    \"address\": \"GuangZhou\",\n    \"password\": \"123456\"\n}"
				},
				"description": "注册接口"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/post",
			"request": {
				"url": "http://localhost:8080/blog/article/post",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n   \"userId\":1,\n   \"title\":\"sbbbbbbb\",\n   \"summary\":\"falfjlfayufanfewelrrewhoq\",\n   \"content\":\"fjalfjdaflqfjeowjfewrojeowrjow\",\n   \"tagName\":\"javaWeb\",\n   \"catName\":\"java\"\n}"
				},
				"description": "发布文章"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/post",
			"request": {
				"url": "http://localhost:8080/blog/article/delete",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n   \"artId\":14\n}"
				},
				"description": "删除文章"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/post",
			"request": {
				"url": "http://localhost:8080/blog/article/modify",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n   \"artDeId\":15,\n   \"content\":\"beyondboy\"\n}"
				},
				"description": "修改文章"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/post",
			"request": {
				"url": "http://localhost:8080/blog/user/getAll",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"description": "获取所有用户信息"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/post",
			"request": {
				"url": "http://localhost:8080/blog/article/limit/get",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"userId\":5,\n    \"offset\":0,\n    \"count\":2\n}"
				},
				"description": "分页获取文章信息"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/look/artdel",
			"request": {
				"url": "http://localhost:8080/blog/article/look/artdel",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n   \"artId\":15\n}"
				},
				"description": "查看文章具体信息"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/match",
			"request": {
				"url": "http://localhost:8080/blog/article/match",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n   \"userId\":1,\n   \"title\":\"我\"\n}"
				},
				"description": "文章模糊查找"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/cat/getAll",
			"request": {
				"url": "http://localhost:8080/blog/article/cat/getAll",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"description": "获取所有分类"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/cat/getAll",
			"request": {
				"url": "http://localhost:8080/blog/article/get/catId",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"userId\":1,\n    \"catId\":10\n}"
				},
				"description": "获取该类的所有文章"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/addCat",
			"request": {
				"url": "http://localhost:8080/blog/article/addCat",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"catna\":\"c\"\n}"
				},
				"description": "添加分类"
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/blog/article/deleteCat",
			"request": {
				"url": "http://localhost:8080/blog/article/deleteCat",
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"description": ""
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"catId\":20\n}"
				},
				"description": "删除分类"
			},
			"response": []
		}
	]
}
```
