<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ja" >
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>POST メソッドのフォーム</title>
</head>
<body>
<h1>HTTP POST メソッド</h1>

<form action="/PiTalk/WebCommand" method="POST">
<p>POST メソッドのフォームの例</p>
<table>
<tr><th>message:</th><td><input type="text" name="cmd" size="50" /></td></tr>
<tr><td></td><td><input type="submit" name="submit" value="送信" /></td></tr>
</table>
</form>

</body>
</html>