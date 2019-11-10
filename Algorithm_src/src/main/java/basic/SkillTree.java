package basic;

import org.junit.Assert;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        for (String skills : skill_trees) {

            int prevIndex = -1;

            boolean bool = true;

            for (int i = 0; i < skill.length(); i++) {

                int indexOf = skills.indexOf(skill.charAt(i));

                if (prevIndex == -1) {
                    prevIndex = indexOf;
                } else if (prevIndex > indexOf || (indexOf == -1 && i < skill.length() - 1)) {
                    bool = false;
                    break;
                }
            }

            if (bool)
                answer++;


        }

        return answer;
    }

    @org.junit.Test
    public void SkillTreeTest1() {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        Assert.assertEquals(2, solution(skill, skill_trees));
    }
}
