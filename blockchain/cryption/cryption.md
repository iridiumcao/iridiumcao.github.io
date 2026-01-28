<script type="module">
    import mermaid from 'https://cdn.jsdelivr.net/npm/mermaid@11/dist/mermaid.esm.min.mjs';
    mermaid.initialize({ startOnLoad: true });
</script>

# 加解密简述

[Index](../index.md)

> 本文面向对密码学感兴趣的初学者，旨在通过简单示例介绍加解密的基本概念。

加密是将数据处理为不易被外人理解的密文，以实现保密。没加密的数据叫明文，加密后的数据叫密文。
解密，就是把密文变成明文。

## 对称加密

对称加密是最古老的密码学方案，简单说，就是用加解密用可逆的方法。

例如，Alice给Bob发一条消息“_我们的最低价是1元_”，为了不让商业对手了解，Alice将这条消息用如下方式加密：每个字的UTF8编码+3。(相关JavaScript代码参[这里](../code/cryption.js))

- “我们的最低价是1元”对应的UTF8（明文）: `[25105, 20204, 30340, 26368, 20302, 20215, 26159, 49, 20803]`
- 给每个值都加上3得到新的数组（密文）: `[25108, 20207, 30343, 26371, 20305, 20218, 26162, 52, 20806]`

对应的汉字是消息是“_戔仯皇會佑仺昲4兆_”，即使被竞争对手截获了消息，也获取不了有用信息。Alice在收到消息后，每个编码减3就能得到消息明文了。上述加 3 的加密方式仅为教学示例，实际对称加密算法如 AES 或 DES 使用复杂的数学运算，安全性远高于简单的编码偏移。

<div class="mermaid">
sequenceDiagram
    participant Alice
    participant Bob
    autonumber
    Alice->>Alice: Encrypt: UTF8 + 3<br>Plaintext: 我们的最低价是1元<br>UTF8: [25105, 20204, ..., 20803]<br>Ciphertext: [25108, 20207, ..., 20806]<br>戔仯皇會佑仺昲4兆
    Alice->>Bob: Send Encrypted Message<br>戔仯皇會佑仺昲4兆
    Bob->>Bob: Decrypt: UTF8 - 3<br>Ciphertext: [25108, 20207, ..., 20806]<br>Plaintext: [25105, 20204, ..., 20803]<br>我们的最低价是1元
    Bob->>Bob: Obtain Plaintext<br>我们的最低价是1元
</div>

对称加密虽然能用，但还是差点意思：

1. 密钥分发。在不安全的信道中，密钥如何安全传递给对方也是一个挑战。密钥需要在安全信道中传输，否则可能被拦截。
2. 密钥管理。当参与方数量增加时，密钥数量会显著增加，管理成本上升。

于是，后来诞生了非对称加密。非对称加密解决了对称加密的密钥分发难题，广泛应用于网络安全领域，例如 HTTPS 网站使用的 SSL/TLS 协议、[数字签名](digital_signature.md)以及比特币等[区块链](../index.md)技术。

## 非对称加密

对称加密系统里，加解密都使用同一个密钥。非对称加密，加解密使用不同的密钥，收发信息双方，各自都有自己的一对密钥，公钥和私钥。为什么需要这么多密钥？因为在非对称加密系统里，加密和解密需要使用不同的密钥。使用私钥加密，则使用公钥解密，反之亦然。为什么可以做到这点，需要更深入的密码学知识（如大整数分解或离散对数问题），将来可能会专门写一篇，这里暂时不谈。

密钥对里，私钥只有自己知道，不能公开给别人，公钥则需公开。在有的实现方案里，公钥可以由私钥计算出来。

同样的例子，Alice给Bob发一条消息“我们的最低价是1元”。假设他们的密钥分别是

|       | Public Key | Private Key |
|:-----:|------------|-------------|
| Alice | aPublicKey | aPrivateKey |
| Bob   | bPublicKey | bPrivateKey |

信息的处理和传递过程是：

1. Alice用自己的私钥aPrivateKey对消息加密。
2. Bob收到消息后，用Alice的公钥aPublicKey解密，并获取信息。

<div class="mermaid">
sequenceDiagram
    participant Alice
    participant Bob
    autonumber
    Alice->>Alice: Encrypt with aPrivateKey
    Alice->>Bob: Send Encrypted Message
    Bob->>Bob: Decrypt with aPublicKey
    Bob->>Bob: Obtain Plaintext
</div>

还可以这样：

1. Alice用Bob的公钥bPublicKey对消息加密。
2. Bob收到消息后，用自己的私钥bPrivateKey解密，并获取信息。

<div class="mermaid">
sequenceDiagram
    participant Alice
    participant Bob

    %% Alice to Bob: Public Key Encryption
    autonumber
    Alice->>Alice: Encrypt with bPublicKey
    Alice->>Bob: Send Encrypted Message
    Bob->>Bob: Decrypt with bPrivateKey
    Bob->>Bob: Obtain Plaintext
</div>

如果Bob要将消息发给Alice，过程也是类似的：

1. Bob用自己的私钥bPrivateKey对消息加密。
2. Alice收到消息后，用Bob的公钥bPublicKey解密，并获取信息。

<div class="mermaid">
sequenceDiagram
    participant Alice
    participant Bob

    %% Bob to Alice: Private Key Encryption
    autonumber
    Bob->>Bob: Encrypt with bPrivateKey
    Bob->>Alice: Send Encrypted Message
    Alice->>Alice: Decrypt with bPublicKey
    Alice->>Alice: Obtain Plaintext
</div>

还可以这样：

1. Bob用Alice的公钥aPublicKey对消息加密。
2. Alice收到消息后，用自己的私钥aPrivateKey解密，并获取信息。

<div class="mermaid">
sequenceDiagram
    participant Alice
    participant Bob

    %% Bob to Alice: Public Key Encryption
    autonumber
    Bob->>Bob: Encrypt with aPublicKey
    Bob->>Alice: Send Encrypted Message
    Alice->>Alice: Decrypt with aPrivateKey
    Alice->>Alice: Obtain Plaintext
</div>

非对称加密是[数字签名](digital_signature.md)的技术基础。数字签名利用非对称加密技术，确保消息的完整性和发送者的身份可信。

在实际应用中，对称加密和非对称加密常结合使用。例如，HTTPS 协议利用非对称加密安全协商一个临时的对称密钥，再用对称加密进行高效的数据传输。

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="zh-CN"
        crossorigin="anonymous"
        async>
</script>