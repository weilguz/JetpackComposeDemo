# ComposeDemo

## 1. Introduction - 项目简介
- 项目名称 -- ComposeDemo
- 这个项目是做什么的？-- 尝试使用jetpack compose来绘制Android的ui
- 查看Commits，每个步骤一条Commit

## 2. ConstraintLayout
- 当有abc三个view依次排列，a和c分别固定在左右两边，b在a和c中间，根据内容显示，长度不固定。不能跟a和c重叠
- 在b中用linkTo(start,end,bias)来约束，c不需要设置start.linkTo(b.end),也不需要给abc三个view设置createHorizontalChain