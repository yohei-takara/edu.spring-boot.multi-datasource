# edu.spring-boot.multi-datasource
Multi data source example.


# memo

spring-boot における静的ファイルのアクセスについてのメモ

spring boot は、デフォルトの設定だと、
`projectDirectory/src/main/resources/META-INF/resources/` 
`projectDirectory/src/main/resources/` 
`projectDirectory/src/main/resources/static/` 
`projectDirectory/src/main/resources/public/`  
の下に配置することで、アクセスが可能となる。

例として、
それぞれのディレクトリに、下記のようにHTMLを配置した場合

```
project root
  └─ src
      └─ main
          └─ resources
              ├─ static
              |   └─ html
              |       └─ 1.html
              ├─ public
              |   └─ html
              |       └─ 2.html
              ├─ resources 
              |   └─ html
              |       └─ 3.html
              └─ META-INF
                  └─ resources
                      └─ html
                          └─ 4.html
```

それぞれのHTMLへは、
`http://localhost:8080/1.html`
`http://localhost:8080/2.html`
`http://localhost:8080/3.html`
`http://localhost:8080/4.html`
という形でアクセスが可能となる。


ただし、下記のように、それぞれのディレクトリに同じ名前のファイルが存在した場合

```
project root
  └─ src
      └─ main
          └─ resources
              ├─ static
              |   └─ html
              |       └─ test.html
              ├─ public
              |   └─ html
              |       └─ test.html
              ├─ resources 
              |   └─ html
              |       └─ test.html
              └─ META-INF
                  └─ resources
                      └─ html
                          └─ test.html

```

`http://localhost:8080/test.html` とアクセスすると、
`META-INF/resources/html/test.html` が返される

静的ファイルの検索順は、

1. `resources/META-INF/resources/`
2. `resources/`
3. `resources/static/`
4. `resources/public/`

の順で検索され、先に見つかったものが画面に返される。

