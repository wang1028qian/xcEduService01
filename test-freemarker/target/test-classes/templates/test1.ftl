<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>
<body>
Hello ${name}!
<br/>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>钱包</td>
        <td>出生日期</td>
    </tr>
    <#if stus??>
    <#list stus as stu>
        <tr>
            <td>${stu_index+1}</td>
            <td <#if stu.name=='小明'>style="background:cornflowerblue"</#if>>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.mondy}</td>
            <td>${stu.birthday?string("yyyy年MM月")}</td>
        </tr>
    </#list>
    <br/>
    学生的个数:${stus?size}
    </#if>
</table>
<br/>
遍历数据模型中的strMap(map数据),第一种方法：在括号中填写ma中的key，第二种方法：在map后边直接加“点key”
<br/>
姓名:${(stuMap['stu1'].name)!''}<br/>
年龄:${(stuMap['stu1'].age)!''}<br/>
姓名:${(stuMap.stu1.name)!''}<br/>
年龄:${(stuMap.stu1.age)!''}<br/>
遍历map中的key.stuMap?keys就是key列表(是一个list)
<br/>
<#list stuMap?keys as k>
姓名:${stuMap[k].name}<br/>
年龄:${stuMap[k].age}<br/>
</#list>
<br/>
${point?c}
<br/>
<#assign text="{'bank':'工商银行','account':'10101920201920212'}"/>
<#assign data=text?eval/>
开户银行:${data.bank}  帐号:${data.account}
</body>
</html>