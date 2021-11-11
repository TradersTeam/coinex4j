# CoinEx4j Library
CoinEx Exchange API JVM Library 

---

|Icon|      Item                          |
| ---:|:------------------------------- |
|📺| [Preview](#Preview)             |
|📱| [Compatibility](#Compatibility) |
|💻| [Usage](#Usage)                 |
|📩| [Download](#Download)           |
|📋| [Features](#Features)           |
|🧾| [Changelog](#Changelog)         |
|⚖️| [License](#License)             |

---

## Preview

## Compatibility
**JVM11+**
## Usage
First of all create a client like this, but keep in mind this will give you a default client with predefined configurations.
```java
CoinEx4J coinEx4J = new CoinEx4J.Builder().build();
```
You can customize your client like this:
```java
CoinEx4J coinEx4J = new CoinEx4J.Builder()
	.autoShutDown(true)
	.accessId("...")
	.secretKey("..")
	.okhttp(...)
	.retrofit(..)
	.baseUrl(...)
	.addConverter(...)
	.build();
```
If you are using this library in JVM only (not Android) like in console for debugging or a server it's suggested to enabling autuShutDown otherwise JVM may or may not exit after task completion depending on OkHttp client timeout, [more info here](https://github.com/square/retrofit/issues/3144).

After creating your client then you need to define API group that you want to use, which are actually retrofit interfaces.
```java
MarketAPIs marketAPIs = coinEx4J.createAPI(MarketAPIs.class);
```
Then you can use different sub APIs under that group.
```java
marketAPIs.getMarketsInfo().asyncBody(coinEx4J, (response, error) -> {
	System.out.println(response.data());
});
```
Custom callbacks are provided using retrofit call adapter feature and Java `Consumer` class however you can still use `enqueue` and `execute` methods. callbacks can be called from Kotlin too. different types of callbacks are explained here.

|Callback|Info|
|-------:|:----------|
|async|returns a callback with type of `BiConsumer` with `Response<T>` and `Throwable` parameters |
|asyncCall|returns two callbacks, one for success (`BiConsumer` with `Call<T>` and `Response<T>` parameters) and another for failure (`BiConsumer` with `Call<T>` and `Throwable` parameters)|
|asyncBody|returns a callback with type of `BiConsumer` with `T` and `Throwable` as parameters|

`T` is response body type.
## Download
### Gradle
### Maven
## Features
### HTTP APIs
- [x] Common APIs
- [x] Market APIs
- [ ] Account APIs
- [ ] Trading APIs
- [ ] Margin APIs
- [ ] Contract APIs
### WebSocket APIs
- [ ] System APIs
- [ ] Market APIs
- [ ] Trading APIs
### Perpetual APIs
#### Perpetual HTTP
- [ ] Common APIs
- [x] System APIs
- [ ] Market APIs
- [ ] Asset APIs
- [ ] Order APIs
- [ ] Position APIs
#### Perpetual WebSocket
- [ ] Server APIs
- [ ] Market APIs
- [ ] Asset APIs
- [ ] Order APIs
- [ ] Position APIs

## Changelog

## License
> CoinEx4J is licensed under the **[GNU General  
> Public License v3.0](./LICENSE)**  
> Permissions of this strong copyleft license are conditioned on making  
> available complete source code of licensed works and modifications,  
> which include larger works using a licensed work, under the same  
> license. Copyright and license notices must be preserved. Contributors  
> provide an express grant of patent rights.
## Contributors
[ArianTron](https://github.com/ariantron)

[Yamin](https://github.com/yamin8000)
