<script type="module">
    import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@11/dist/mermaid.esm.min.mjs';
    mermaid.initialize({ startOnLoad: true });
</script>

# 数字签名

[Index](../index.md)

数字签名（Digital Signature，也称“數位簽章”或“公鑰數位簽章”）是一种基于密码学技术的身份验证和数据完整性保障机制。

在数字时代以前，我们在很多场合通过签名来标识身份，比如书信和契约书上的签名，等等。这些签名或者是按手印，或者是手写，或者是印章，方式多样，但目的都只有一个，就是确定相关人的身份。

数字文件没有物理实体，当然不能用这些方式签名，但它也有它的签名方式，我们一般就称它为数字签名。数字签名广泛应用网络世界中，为网络安全保驾护航，如电子合同、软件分发（如验证软件未被篡改）、区块链交易、电子邮件签名（如PGP）以及SSL/TLS证书验证等场景。

以下举例说明数字签名的流程。

假如Alice要给Bob发一条带有签名的消息，Bob收到消息后能确认两件事：

1. 消息是Alice发送的
2. 消息没有被篡改

数字签名在密码学中，使用的技术是非对称加密技术，在[数据加密简介](cryption.md)第二部分有简单提到。非对称加密基于公钥和私钥对，通常私钥用于签名，公钥用于验证。

借用维基百科的图片说明流程

![](https://upload.wikimedia.org/wikipedia/commons/6/66/Digital_Signature_diagram_zh-CN.svg)

1. Alice使用某hash算法（如SHA-256、SHA-3）对消息生成摘要信息digest_a
2. Alice使用私钥对摘要信息加密，加密后的文本即是数字签名ds
3. Alice将数字签名ds以及数字证书（CA的认证）和原信息汇集在一起，并发送给Bob
4. Bob收到消息后也使用同样的hash算法对消息生成摘要信息digest_b
5. Bob验证数字证书的CA签名以确认证书可信，然后从中提取Alice的公钥。
6. Bob使用Alice的公钥对Alice的签名解密，如果能正常解密，则消息是Alice发送的，如果解压出的内容和摘要信息digest_b相同，则消息没有被篡改

<div class="mermaid">
sequenceDiagram
    participant Alice
    participant CA
    participant Bob

    Alice->>Alice: 1. 对消息使用 hash 算法生成摘要 digest_a
    Alice->>Alice: 2. 使用私钥加密 digest_a 生成数字签名 ds
    Alice->>Bob: 3. 发送消息、ds 和数字证书

    Bob->>Bob: 4. 对消息使用相同 hash 算法生成摘要 digest_b
    Bob->>CA: 5. 获取 CA 的公钥（通常预装）
    Bob->>Bob: 5. 使用 CA 公钥验证数字证书的签名
    Note right of Bob: 若验证通过，证书可信，提取 Alice 公钥

    Bob->>Bob: 6. 使用 Alice 公钥解密 ds，得到 digest_a
    Bob->>Bob: 6. 比较 digest_a 与 digest_b
    Note right of Bob: 若一致，消息未被篡改且来自 Alice
</div>

以上第4步，根据hash的原理，如果消息没有被篡改，digest_a和digest_b应该是相同的。在第6步中，Bob使用公钥解密数字签名得到digest_a，并与自己计算的digest_b比较。若两者一致，则确认消息未被篡改且来自Alice。

CA（证书颁发机构）负责颁发数字证书，证明公钥的所有者身份。数字证书包含公钥、身份信息以及CA的签名，确保公钥的可信性。以上第5步，有一个隐患，如果CA系统出了问题，则整个系统便不可靠。这也是数字签名系统里不可避免的缺陷：必须信任CA这个中心化机构。

Alice发送的消息可能被篡改吗？如果要篡改，就需要重新生成消息签名，而这需要Alice的私钥。也就是只要Alice的私钥不泄露，篡改消息是不可能的。所以，一定要保管好自己的私钥，防止身份被冒用。

Bob验证消息的签名通过，只表示这个消息是拥有Alice私钥的人发出来的。所以这里也有一个漏洞，如果Alice想反悔，她可以撒谎说她的私钥被偷了。

不可否认性是指发送者无法否认其发送的消息，因为数字签名依赖于私钥，而私钥由发送者独有。只要Alice的私钥不被冒用，那么消息就能确定是不是Alice发送的，而且Alice不能抵赖。当然也基于对CA完全正常的假设。

如果CA被黑。有人冒充Alice身份，并更换了Alice的公钥，然后发送消息给Bob，Bob显然无法知晓Alice的真伪。此时，如果Bob足够警惕，可能去询问Alice是否更新了公钥。同样，如果CA被黑，黑客将CA保存的公钥胡乱篡改一番，即使不传递伪造的消息，也能引起很大的混乱。

---

参考资料

* [维基百科·数字签名](https://zh.wikipedia.org/wiki/%E6%95%B8%E4%BD%8D%E7%B0%BD%E7%AB%A0)
