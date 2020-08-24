package com.paul.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/**
 * @author zmm233489
 * @date 2020/8/15
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        if (Objects.isNull(s) && Objects.isNull(p)) {
            return true;
        }

        if (Objects.isNull(s) || Objects.isNull(p)) {
            return false;
        }

        if (s.equals(p)) {
            return true;
        }

        return doMatch_opt(s, 0, p, 0);
    }

    /**
     * pStart 和 sStart 的位置都是带匹配
     * @param s
     * @param sStart
     * @param p
     * @param pStart
     * @return
     */
    private boolean doMatch(String s, int sStart, String p, int pStart) {
        if (sStart >= s.length() && pStart >= p.length()) {
            return true;
        }

        if (pStart >= p.length()) {
            return false;
        }

        if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
            int countPCurrent = 0;

            while (sStart + countPCurrent < s.length() && (p.charAt(pStart) == '.' || s.charAt(sStart + countPCurrent) == p.charAt(pStart))) {
                ++countPCurrent;
            }

            for (int i = countPCurrent; i >= 0; --i) {
                if (doMatch(s, sStart + i, p, pStart + 2)) {
                    return true;
                }
            }
        } else if (sStart < s.length() && (p.charAt(pStart) == '.' || s.charAt(sStart) == p.charAt(pStart))) {
            return doMatch(s, sStart + 1, p, pStart + 1);
        }

        return false;
    }

    /**
     * pStart 和 sStart 的位置都是带匹配
     * @param s
     * @param sStart
     * @param p
     * @param pStart
     * @return
     */
    private boolean doMatch_opt(String s, int sStart, String p, int pStart) {
        if (pStart >= p.length()) {
            return sStart >= s.length();
        }

        if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
            return sStart < s.length() && (p.charAt(pStart) == '.' || s.charAt(sStart) == p.charAt(pStart)) ? doMatch_opt(s, sStart, p, pStart + 2) || doMatch_opt(s, sStart + 1, p, pStart) : doMatch_opt(s, sStart, p, pStart + 2);
        }

        if (sStart < s.length() && (p.charAt(pStart) == '.' || s.charAt(sStart) == p.charAt(pStart))) {
            return doMatch_opt(s, sStart + 1, p, pStart + 1);
        }

        return false;
    }

    public boolean isMatch_dp(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public boolean isMatch_patternIndex(String s, String p) {
        if (Objects.isNull(s) && Objects.isNull(p)) {
            return true;
        }

        if (Objects.isNull(s) || Objects.isNull(p)) {
            return false;
        }

        if (s.equals(p)) {
            return true;
        }

        Set<Integer> nextPatternIndexs = new HashSet<>(), nowPatternIndexs;

        int index = 0;

        addNextPatternIndex(p, 0, nextPatternIndexs);

        while (!nextPatternIndexs.isEmpty()) {
            nowPatternIndexs = nextPatternIndexs;

            nextPatternIndexs = new HashSet<>();

            for (Integer pIndex : nowPatternIndexs) {
                if (pIndex >= p.length() && index >= s.length()) {
                    return true;
                }

                if (pIndex >= p.length()) {
                    continue;
                }

                if (index < s.length() && (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(index))) {
                    if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
                        addNextPatternIndex(p, pIndex, nextPatternIndexs);
                    } else {
                        addNextPatternIndex(p, pIndex + 1, nextPatternIndexs);
                    }
                }
            }

            ++index;
        }

        return false;
    }

    private void addNextPatternIndex(String p, int nextPindex, Set<Integer> nextPatternIndexs) {
        nextPatternIndexs.add(nextPindex);

        if (nextPindex + 1 < p.length() && p.charAt(nextPindex + 1) == '*') {
            addNextPatternIndex(p, nextPindex + 2, nextPatternIndexs);
        }
    }

    public boolean isMatch_stateMachine(String s, String p) {
        if (Objects.isNull(s) && Objects.isNull(p)) {
            return true;
        }

        if (Objects.isNull(s) || Objects.isNull(p)) {
            return false;
        }

        if (s.equals(p)) {
            return true;
        }

        StateNode startState = generateStateMachine(p);

        return matchFromNode(s, 0, startState);
    }

    public boolean matchFromNode(String s, int sStart, StateNode stateNode) {
        if (sStart >= s.length()) {
            return stateNode.isEnd;
        }

        List<StateNode> nextStates = new ArrayList<>();

        if (stateNode.transferMap.get(s.charAt(sStart)) != null) {
            nextStates.addAll(stateNode.transferMap.get(s.charAt(sStart)));
        }

        if (stateNode.transferMap.get('.') != null){
            nextStates.addAll(stateNode.transferMap.get('.'));
        }

        if (nextStates == null || nextStates.isEmpty()) {
            return false;
        }

        for (StateNode node : nextStates) {
            if (matchFromNode(s, sStart + 1, node)) {
                return true;
            }
        }

        return false;
    }

    public StateNode generateStateMachine(String p) {
        StateNode startState = new StateNode('#'), newState = null;
        List<StateNode> preStates = new ArrayList<>();
        preStates.add(startState);

        for (int i = 0; i < p.length();) {
            newState = new StateNode(p.charAt(i));

            for (StateNode stateNode : preStates) {
                putStateNode(stateNode, p.charAt(i), newState);
            }

            if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                putStateNode(newState, p.charAt(i), newState);
                i += 2;
            } else {
                preStates.clear();
                ++i;
            }

            preStates.add(newState);
        }

        for (StateNode stateNode : preStates) {
            stateNode.isEnd = true;
        }

        return startState;
    }

    /**
     * 往状态节点map里添加下一个状态节点
     * @param stateNode
     * @param pPattenr
     * @param addedState
     */
    public void putStateNode(StateNode stateNode, char pPattenr, StateNode addedState) {
        List<StateNode> stateNodes = stateNode.transferMap.get(pPattenr);

        if (stateNodes == null) {
            stateNodes = new ArrayList<>();
            stateNode.transferMap.put(pPattenr, stateNodes);
        }

        stateNodes.add(addedState);
    }

    public class StateNode {
        private Map<Character, List<StateNode>> transferMap;

        boolean isEnd;

        char value;

        public StateNode(char value) {
            this.value = value;
            transferMap = new HashMap<>();
            isEnd = false;
        }
    }

    public static void main(String[] args) {
        //StateNode stateNode = new IsMatch().generateStateMachine("mis*i*j*k");
        //System.out.println(stateNode);
        System.out.println(new IsMatch().isMatch_stateMachine("bbba", ".*b"));
    }
}
