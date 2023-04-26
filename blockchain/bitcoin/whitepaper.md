# Understand Bitcoin Write Paper, 理解比特币白皮书

按：本文将详细解读白皮书原版（英文版）的全部内容，会参照官网的中译本。对官网的中译本不认同之处会在文中指出。

白皮书：

* [bitcoinpaper.info](https://www.bitcoinpaper.info)
* [bitcoin.org](https://bitcoin.org/en/bitcoin-paper): [英文版](https://bitcoin.org/bitcoin.pdf), [简体中文版](https://bitcoin.org/files/bitcoin-paper/bitcoin_zh_cn.pdf)
* 本站备份: [英文版](bitcoin_en.pdf), [简体中文版](bitcoin_zh_cn.pdf)

## 标题

> Bitcoin: A Peer-to-Peer Electronic Cash System
> 比特币：一种点对点电子现金系统

1. bitcoin翻译为比特币，非常好，音考虑到了，意也考虑到了。
2. 官方中文版将标题译为"比特币：一种点对点电子现金系统"，将cash译作货币，不是很妥，虽然很多时候，现金和货币是等同的概念，但也很多时候，货币不只是现金。还是按本意译作现金更好，有没有货币的含义，看它的使用场景由用户去定义吧。

## 作者署名

> Satoshi Nakamoto
> satoshin@gmx.com

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

> Abstract. A purely peer-to-peer version of electronic cash would allow online payments to be sent directly from one party to another without going through a financial institution. Digital signatures provide part of the solution, but the main benefits are lost if a trusted third party is still required to prevent double-spending. We propose a solution to the double-spending problem using a peer-to-peer network. The network timestamps transactions by hashing them into an ongoing chain of hash-based proof-of-work, forming a record that cannot be changed without redoing the proof-of-work. The longest chain not only serves as proof of the sequence of events witnessed, but proof that it came from the largest pool of CPU power. As long as a majority of CPU power is controlled by nodes that are not cooperating to attack the network, they'll generate the longest chain and outpace attackers. The network itself requires minimal structure. Messages are broadcast on a best effort basis, and nodes can leave and rejoin the network at will, accepting the longest proof-of-work chain as proof of what happened while they were gone.


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

## 1. Introduction

> Commerce on the Internet has come to rely almost exclusively on financial institutions serving as trusted third parties to process electronic payments.  While the system works well enough for most transactions, it still suffers from the inherent weaknesses of the trust based model. Completely non-reversible transactions are not really possible, since financial institutions cannot avoid mediating disputes. The cost of mediation increases transaction costs, limiting the minimum practical transaction size and cutting off the possibility for small casual transactions, and there is a broader cost in the loss of ability to make non-reversible payments for non- reversible services. With the possibility of reversal, the need for trust spreads. Merchants must be wary of their customers, hassling them for more information than they would otherwise need. A certain percentage of fraud is accepted as unavoidable. These costs and payment uncertainties can be avoided in person by using physical currency, but no mechanism exists to make payments over a communications channel without a trusted party.
>
> What is needed is an electronic payment system based on cryptographic proof instead of trust, allowing any two willing parties to transact directly with each other without the need for a trusted third party. Transactions that are computationally impractical to reverse would protect sellers from fraud, and routine escrow mechanisms could easily be implemented to protect buyers. In this paper, we propose a solution to the double-spending problem using a peer-to-peer distributed timestamp server to generate computational proof of the chronological order of transactions. The system is secure as long as honest nodes collectively control more CPU power than any cooperating group of attacker nodes.


解读如下

> Commerce on the Internet has come to rely almost exclusively on financial institutions serving as trusted third parties to process electronic payments.

网上的交易已经变得的几乎完全依赖金融机构作为可信第三方来处理电子支付了。

> While the system works well enough for most transactions, it still suffers from the inherent weaknesses of the trust based model.

虽然当前的系统对绝大多数交易来说，运行得足够好，但还是要忍受现有信任模式固有弱点。
一句话，当前的CA模式有先天缺陷。

> Completely non-reversible transactions are not really possible, since financial institutions cannot avoid mediating disputes.

完全不可撤销的交易是不可能的，因为金融机构不可避免调解纠纷。试想，本来A支付给B一块钱，但A反悔了，机构参与调解，撤销了这笔交易。其实不用撤销也能做到退钱，就是再让B支付A一块钱就行了。也就是交易能否撤销都不影响真实世界的金钱往来。但是，不可撤销的交易，看起来有利于保存原始的交易记录，方便对账。银行以及其他很多第三方记账，可能更多也参与再发起交易，而不是撤销。具体怎么，不得而知。不过，可以肯定的是，银行是有撤销交易的能力的，这就给它主动撤销交易并不留痕迹创造了条件。可撤销就是可抵赖。比特币将从技术上让撤销操作不可能实现。后面的正文会有更多内容说明。

> The cost of mediation increases transaction costs, limiting the minimum practical transaction size and cutting off the possibility for small casual transactions, and there is a broader cost in the loss of ability to make non-reversible payments for non-reversible services. 

调解纠纷增加了交易成本，限制了最小交易额度而杜绝了日常小额交易的可能性，它因为无能实现不可逆交易和无能提供不可逆服务而不得不支付更大的成本。确实是这样，撤销一次交易，需要修改和矫正的数据可能比较多不说，还可能出错。这些都是成本。但中本聪提到这种情况限制了小额交易，这点倒也未必，当前的支付宝和微信对小额交易支持得就非常好，张三付给李四1分钱都行方便。

> With the possibility of reversal, the need for trust spreads. 

由于交易有撤销的可能，对信任的需求也就更广泛。

这句话很短，但并不好理解，它包含了两个重句。

* with the possibility of reversal 这句要结合前文理解，是指撤销交易的可能性，光看这句，会一头雾水。
* the need for trust spreads 这是整个句子的主句，但这句话本身由是一个主语从句，它的主语是 the need for trust (对信任的需求)

这句话官网的中译本翻译得很不错。它这样译：“由于存在交易被撤销的可能性，对信任的需求将更广泛。”

但不管怎么翻译，都还是有再创造的问题，这也是要读原文的意义。

> Merchants must be wary of their customers, hassling them for more information than they would otherwise need.

商人必须非常小心他们的客户，以至于惹人烦也要求客户提供超过他们所需的信息。这个不知中本聪在美国怎么也有这个体会，我在中国对这点体会是非常非常深的，现在办银行卡还要开证明，存取款几万块就要说明，岂有此理！这也说明比特币存在是非常有用的。

> A certain percentage of fraud is accepted as unavoidable.

一定比例的欺诈因为无法避免，只好接受。其实，比特币虽然在技术上避免了欺诈，但社会工程学上的欺诈仍然避免，当然这不是技术能解决的问题了。

> These costs and payment uncertainties can be avoided in person by using physical currency, but no mechanism exists to make payments over a communications channel without a trusted party.

这些费用和付款不确定性可以通过使用实物货币来避免，但是在没有信任方的情况下，不存在通过通信渠道进行付款的机制。

* in person表示“当面”、“亲自”，是介词短语，修饰使用实物货币。
* physical currency是名词短语，表示实物货币。
* no mechanism exists是主语+谓语结构，表示没有机制。
* to make payments over a communications channel是不定式短语，表示通过通信渠道进行付款。

这段话是很地道的英语，但对我来说读起来比较拗口，用ChatGPT帮助翻译和解释如上（摘录）。不得不说，ChatGPT确实是神器。

> What is needed is an electronic payment system based on cryptographic proof instead of trust, allowing any two willing parties to transact directly with each other without the need for a trusted third party.

我们需要一个基于密码学而不是基于信任的电子支付系统，这个系统允许有交易意愿的双方直接交易而无需依赖可信的第三方。

这句话，英文比中文更好理解些，也更顺畅些。所以翻译版只能用作参考的原因也在这里。

> Transactions that are computationally impractical to reverse would protect sellers from fraud, and routine escrow mechanisms could easily be implemented to protect buyers.

无法通过计算手段轻易撤销的交易可以保护卖家免受欺诈，常规的第三方担保机制可以轻松实现以保护买家。

上面这句仍然是ChatGPT帮助翻译的，真心不错。

* escrow mechanism 托管机制，第三方担保机制，这是一个比较金融化的词，不太清楚具体含义，留待后面回头看。

问ChatGPT: 请讲解escrow，包括词源，历史流变，现在的用法，并举例。

ChatGPT答: "Escrow"是指在交易双方之间设立第三方担保的一种安排，以确保交易的安全性和公正性。它可以用于房地产、金融和电子商务等领域。

该词的词源可以追溯到古法语的"escroue"，意为"卷轴"。后来演变为英语中的"escrow"，指的是由律师、银行或其他第三方代理人管理的文件、契约或资金，以保证在某些条件下安全地交付给交易的接收方。

现代用法中，escrow通常指的是第三方保管金钱或文件的安排。在房地产交易中，买卖双方会将房屋的购买价款交付给一个中介机构，该机构将在满足交易条件（如验房、产权证明等）后，将款项转交给卖方。在软件和电子商务领域中，escrow也可以用于保护交易双方的权益，以避免欺诈或未履行交易承诺的情况。

举个例子，如果某个买家希望购买某个卖家的网站，但担心卖家不会提供完整的代码和资料，他们可以将购买款项交给一个第三方机构，这个机构会在确认代码和资料完整性后，将款项转交给卖家。这样，买家就可以放心地购买网站，而卖家也能获得款项。

> In this paper, we propose a solution to the double-spending problem using a peer-to-peer distributed timestamp server to generate computational proof of the chronological order of transactions.

在这篇论文里，我们提出了一个解决双花问题的方案：使用点对点分布式时间戳服务器去按时间顺序生成可以计算验证的交易。

中文版里的翻译：在这篇论文中，我们提出一种使用点对点分布式时间戳服务器为基于时间的交易序列生成计算上的证据来解决双重支付问题的方案。

ChatGPT的翻译和讲解：

这篇论文提出了一种解决双花问题的方案，使用点对点分布式时间戳服务器来生成交易的时间顺序的计算证明。

在比特币等加密货币领域，双花问题是指在进行交易时，同一笔资金被用于多个交易，从而导致交易的可靠性和有效性受到破坏。为了解决这个问题，论文提出使用分布式时间戳服务器来记录交易的时间戳，以证明其发生的先后顺序，从而防止双花问题的发生。

分布式时间戳服务器可以由网络上的任何节点来提供，它们会将交易时间戳打上数字签名并广播到网络中。其他节点会验证该交易的时间戳和签名，并将其添加到区块链中，从而确保交易的可靠性和有效性。

因此，使用分布式时间戳服务器可以解决双花问题，保证交易的可靠性和有效性，是区块链技术的核心之一。

点评：在我、中文版和ChatGPT三个翻译版本中，ChatGPT的版本似乎是最好的。

> The system is secure as long as honest nodes collectively control more CPU power than any cooperating group of attacker nodes.

只要诚实节点合作控制更多的CPU并超过任何攻击者的节点，系统就是安全的。
