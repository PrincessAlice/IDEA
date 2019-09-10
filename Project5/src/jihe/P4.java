package jihe;

import java.util.*;

public class P4 {
    public static class StringComparator implements Comparator<String>{
        @Override
        public int compare(String o1,String o2){
            return  o1.compareTo(o2);
        }
    }
    //统计单词出现的次数
    Map<String,Integer>count(String[] words){
        Map<String,Integer> wordToCount = new HashMap<>();
        for(String word:words){
            int c = wordToCount.getOrDefault(word,0);
            wordToCount.put(word,c+1);
        }
        return wordToCount;
    }

    //每个次数 ——>那些单词
    private static  Map<Integer,List<String>> remap(Map<String,Integer>wordToCount){
        Map<Integer,List<String>> countToWordList = new HashMap<>();
        for(Map.Entry<String,Integer> e:wordToCount.entrySet()){
            String word = e.getKey();
            int count = e.getValue();

            List<String>  wordList = countToWordList.get(count);
            if(wordList == null){
                wordList = new ArrayList<>();
                countToWordList.put(count,wordList);
            }
            wordList.add(word);
        }
        return countToWordList;
    }

     //先确定单词对应—>次数 ，再反转次数—>单词，获取出现频数最高的前K个且按字母顺序有序排列打印
    public List<String> topKFrequent(String[] words,int k){
        Map<String,Integer>wordToCount = count(words);
        Map<Integer,List<String>> countToWordList = remap(wordToCount);
        // 目的是为了将所有出现次数放到一个int[]中
        Set<Integer> keys = countToWordList.keySet();  //调出现次数
        int[] counts = new int[keys.size()];
        int i = 0;
        for(int key: keys){
            counts[i++] = key;
        }
        Arrays.sort(counts);

        //录取名单
        List<String> result = new ArrayList<>();
        int j = 0;      //已录取的名单
        int index = counts.length - 1;      //当前选择的分数，因为从小到大排序
        Comparator<String> comparator = new StringComparator();  //按照字母顺序排序
        while(j < k){
            int c = counts[index--];        //得到最大分
            //为了获取当前考c分的人数
            List<String> wordList = countToWordList.get(c);
            wordList.sort(comparator);      //人按照字母排序
            if(wordList.size() <= k-j){     //如果当前分数的人数 <= 还差的人数
                result.addAll(wordList);
                j += wordList.size();
            }else{      //否则只选前k-j 个
                result.addAll(wordList.subList(0,k-j));  //subList:从list中截取一部分[0,k-j)
                j = k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {
                "i","love","leetcode",
                "i","love","coding"
        };
        List<String> r = new P4().topKFrequent(words,3);
        System.out.println(r);
    }
}
