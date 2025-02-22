```markdown
# Algorithm Showcase 🚀

**持续更新的算法实战仓库 | 结构化代码 | 完整解题文档 | 可复现测试用例**

![](https://img.shields.io/badge/Java-17-007396?logo=java)
![](https://img.shields.io/github/last-commit/NullCat/Algorithm-Showcase?color=blue)
![](https://img.shields.io/github/repo-size/NullCat/Algorithm-Showcase?color=success)

## 项目概览

本仓库系统化整理我在算法学习过程中的实战记录，包含：

- **LeetCode 热题 HOT 100**（高频面试题精选）
- **牛客网**（国内大厂真题专项）
- **洛谷**（经典算法题型训练）

每个题目提供**多解法实现** + **可执行测试用例** + **复杂度分析**，代码符合Google Java编码规范，适合算法学习者参考和面试准备。

---

## 📂 目录结构

```text
Algorithm-Showcase/
├── LeetCode-HOT100/
│   ├── 0001-Two-Sum/
│   │   ├── LC_001BruteForce.java       # 题解1暴力枚举实现
│   │   ├── LC_001HashMap.java          # 题解2哈希表实现
│   │   ├── README.md              # 题目描述/解题思路/复杂度分析
│   │   └── test.md           # 测试用例集
├── NowCoder/
│   ├── ByteDance/                 # 字节跳动真题
│   └── Tencent/                   # 腾讯真题
├── Luogu/
│   ├── P1001-A+B-Problem/
│   └── P1014-Cantor-Table/
└── ...（持续更新）
```

---

## 🧩 代码结构示例

### 典型题目目录
```text
/LeetCode-HOT100/0001-Two-Sum
│
├── Solution.java                # 核心实现类
├── Solution_HashMap.java        # 哈希表解法
├── Solution_BruteForce.java     # 暴力解法
├── README.md                    # 包含：
│   └── ## 解题思路
│       ├️ 暴力解法 → O(n²)
│       └── 哈希表优化 → O(n)
├── testcases.md                 # 标准化测试用例：
│   └── 示例:
│       Input: nums = [2,7,11,15], target = 9
│       Output: [0,1]
└── SolutionTest.java            # JUnit测试类
```

---

## 🛠 如何使用本仓库

### 学习者指南
1. **按平台检索**：直接进入对应平台（LeetCode/牛客/洛谷）的目录
2. **多解法对比**：查看同一题目的不同.java文件学习优化思路
3. **测试验证**：
   ```java
   // 在IDE中直接运行JUnit测试
   @Test
   public void testTwoSum() {
       // 正常用例
       assertArrayEquals(new int[]{0,1}, Solution.twoSum(new int[]{2,7,11,15}, 9));
       
       // 边界用例
       assertArrayEquals(new int[]{0,1}, Solution.twoSum(new int[]{3,3}, 6));
   }
   ```
4. **文档学习**：README.md中的复杂度分析助您理解算法优劣

### 面试准备建议
- 通过`/LeetCode-HOT100`目录重点刷高频题
- 牛客网真题按公司分类（见子目录）
- 洛谷题目按算法标签分类

---

## 💡 项目亮点（致HR）

### 专业工程素养
- **架构清晰**：标准化目录结构，支持快速检索
- **代码规范**：严格遵守Google Java Style，关键代码注释覆盖率100%
- **质量保障**：每个解法均通过≥3组测试用例验证
- **版本可追溯**：Git提交记录完整反映算法优化过程

### 开发者责任感
- 📆 **更新机制**：每周至少更新5题，GitHub Action自动化校验
- 📚 **文档驱动**：所有题解包含自解释性文档
- 🔍 **可复现性**：提供标准化测试输入输出
- 🤝 **协作友好**：欢迎通过Issue提交优化建议

---

## 🚧 持续建设计划

- [ ] 增加Python/Scala多语言实现
- [ ] 补充算法可视化图解
- [ ] 建设自动化测试流水线
- [ ] 添加「每日一题」讨论区

---

## License
[MIT License](LICENSE) © [Nu11Cat]

---

> 本仓库的commit记录就是我的算法成长日记，欢迎通过[Issues]提交建议或[Pull Requests]共同完善！
```

