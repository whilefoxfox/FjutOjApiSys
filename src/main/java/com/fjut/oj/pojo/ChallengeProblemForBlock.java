package com.fjut.oj.pojo;

/**
 * @Author: axiang [20190628]
 */
public class ChallengeProblemForBlock {

    /**
     * solved： 0: 未做过  1：AC过  其他：做过但未AC过
      */
    private Integer solved;
    private Integer blockId;
    private Integer problemId;
    private Integer trueProblemId;
    private String title;
    private Integer score;


    public Integer getSolved() {
        return solved;
    }

    public void setSolved(Integer solved) {
        this.solved = solved;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getTrueProblemId() {
        return trueProblemId;
    }

    public void setTrueProblemId(Integer trueProblemId) {
        this.trueProblemId = trueProblemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "isSolved: " + solved
                + " blockId: " + blockId
                + " pid: " + problemId
                + " tpid: " + trueProblemId
                + " title: " + title
                + " score: " + score;
    }
}
