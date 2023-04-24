# Understand Bitcoin Write Paper, 理解比特币白皮书

按：本文将详细解读白皮书原版（英文版）的全部内容，会参照官网的中译本。对官网的中译本不认同之处会在文中指出。

[白皮书主页](https://www.bitcoinpaper.info), [白皮书主页](https://bitcoin.org/en/bitcoin-paper), [白皮书英文版](https://bitcoin.org/bitcoin.pdf), [白皮书简体中文版](https://bitcoin.org/files/bitcoin-paper/bitcoin_zh_cn.pdf), [本站英文版](bitcoin_en.pdf), [本站简体中文版](bitcoin_zh_cn.pdf)

## 标题

```plaintext
Bitcoin: A Peer-to-Peer Electronic Cash System
比特币：一种点对点电子现金系统
```

1. bitcoin翻译为比特币，非常好，音考虑到了，意也考虑到了。
2. 官方中文版将标题译为"比特币：一种点对点电子现金系统"，将cash译作货币，不是很妥，虽然很多时候，现金和货币是等同的概念，但也很多时候，货币不只是现金。还是按本意译作现金更好，有没有货币的含义，看它的使用场景由用户去定义吧。

## 作者署名

```plaintext
Satoshi Nakamoto
satoshin@gmx.com
```

Satoshi Nakamoto是中本聪的日语名字的罗马转写，对应的日文假名是“サトシ・ナカモト”，因为作者自称日裔美国人，且他没有公开自己的汉字名，所以在日本没有标准的汉字名，但有“中本聡”和“中本哲史”两种写法。简体中文里一般作“中本聪”，繁体中文一般作“中本聰”。

|    | 英文（日语罗马字） | 日文汉字 | 日文假名 | 简体汉字 | 繁体汉字 |
|----|--------------------|----------|----------|----------|----------|
| 姓 | Nakamoto           | 中本     | ナカモト | 中本     | 中本     |
| 名 | Satoshi            | 哲史/聡  | サトシ   | 聪       | 聰       |

参考内容：

* [维基百科，中本聪，中文词条](https://zh.wikipedia.org/wiki/%E4%B8%AD%E6%9C%AC%E8%81%AA)
* [维基百科，中本聪，日文词条](https://ja.wikipedia.org/wiki/%E3%82%B5%E3%83%88%E3%82%B7%E3%83%BB%E3%83%8A%E3%82%AB%E3%83%A2%E3%83%88)
* [维基百科，中本聪，英文词条](https://en.wikipedia.org/wiki/Satoshi_Nakamoto)

中本聪发布白皮书使用的邮箱是satoshin@gmx.com. gmx.com是一个免费的邮件服务商，据说服务质量很不错，现在(2023.04.24)仍然在运营。不清楚中本聪使用它的具体原因。

## 摘要

```plaintext
Abstract. A purely peer-to-peer version of electronic cash would allow online payments to be sent directly from one party to another without going through a financial institution. Digital signatures provide part of the solution, but the main benefits are lost if a trusted third party is still required to prevent double-spending. We propose a solution to the double-spending problem using a peer-to-peer network. The network timestamps transactions by hashing them into an ongoing chain of hash-based proof-of-work, forming a record that cannot be changed without redoing the proof-of-work. The longest chain not only serves as proof of the sequence of events witnessed, but proof that it came from the largest pool of CPU power. As long as a majority of CPU power is controlled by nodes that are not cooperating to attack the network, they'll generate the longest chain and outpace attackers. The network itself requires minimal structure. Messages are broadcast on a best effort basis, and nodes can leave and rejoin the network at will, accepting the longest proof-of-work chain as proof of what happened while they were gone.
```

解读如下

> A purely peer-to-peer version of electronic cash would allow online payments to be sent directly from one party to another without going through a financial institution.

注意"A purely peer-to-peer version of electronic cash"，中本聪要创建一个100%的点对点的现金系统，这句话每个字都很重要：

* purely: 100%的，没的通融
* electronic cash: 是什么（电子现金）
* peer-to-peer: 模式
* directly: 不要中介
* without going through a financial institution: 再次强调不要金融机构参与

一个纯粹的点对点电子现金系统应该允许这样的交易：一个交易者直接向另一个交易者付费，无需金融机构参与。

> Digital signatures provide part of the solution, but the main benefits are lost if a trusted third party is still required to prevent double-spending.

这里指出了现有方案的缺陷。它说，数字签名能（为前述纯粹的电子交易）提供部分解决方案，但因为不得不依赖第三方机构去阻止双花，这个解决方案也就没什么益处了。这里提到的第三方机构是CA，[维基百科](https://zh.wikipedia.org/wiki/%E8%AF%81%E4%B9%A6%E9%A2%81%E5%8F%91%E6%9C%BA%E6%9E%84)解释为：

> 数字证书认证机构（英語：Certificate Authority，缩写为CA），也称为电子商务认证中心、电子商务认证授权机构，是负责发放和管理数字证书的权威机构，并作为电子商务交易中受信任的第三方，承担公钥体系中公钥的合法性检验的责任。

怎么样，这个CA听起来不错吧？但如果CA本身作恶，或者CA被黑，又如何保证安全？这是个小概率问题，但真的出现的话，却非常严重。中本聪当然也想到了这点，所以，想要建立一个不需要信任或依赖任何第三方的现金交易系统。

> We propose a solution to the double-spending problem using a peer-to-peer network.

中本聪的方案是通过P2P网络来解决双花问题。

> The network timestamps transactions by hashing them into an ongoing chain of hash-based proof-of-work, forming a record that cannot be changed without redoing the proof-of-work.

(P2P)网络用哈希的方式给交易打上时间戳，交易记录存在一个基于哈希的工作量证明的链上。除非重新证明工作量，交易记录不可能被篡改。所谓的工作量证明proof-of-work, 一般简称为POW，就是计算出一个符合规则的随机数，这个后面的正文里会提到，这里如果不理解可以先跳过回头再看。

> The longest chain not only serves as proof of the sequence of events witnessed, but proof that it came from the largest pool of CPU power.

最长的链不仅用来见证事件发生的序列，还用来证明交易来自CPU最强的算力池。

> As long as a majority of CPU power is controlled by nodes that are not cooperating to attack the network, they'll generate the longest chain and outpace attackers.

只要拥有大部分CPU算力的节点不会勾结起来攻击网络，它们会创建一个最长的链去超过攻击者。

 > The network itself requires minimal structure.
 
 这个（P2P）网络本身需要很小的结构。
 听起来好像挺简单的。

 > Messages are broadcast on a best effort basis, and nodes can leave and rejoin the network at will, accepting the longest proof-of-work chain as proof of what happened while they were gone.

交易信息被尽可能广播，各个节点可以自由加入或离开网络，并接受最长的工作量证明的链作为他们离开期间发生的（交易）事件的证据。这段话听起来优点拗口。

如果对比特币机制了解较少，这个摘要的部分内容会让人一头雾水。没关系，接下会详细阅读正文内容。
