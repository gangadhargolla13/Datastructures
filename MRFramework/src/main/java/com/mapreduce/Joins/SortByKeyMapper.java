package com.mapreduce.Joins;

public class SortByKeyMapper extends Mapper<LongWritable, Text, Text, Text> {

    private int keyIndex;
    private Splitter splitter;
    private Joiner joiner;
    private Text joinKey = new Text();


    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        String separator =  context.getConfiguration().get("separator");
        keyIndex = Integer.parseInt(context.getConfiguration().get("keyIndex"));
        splitter = Splitter.on(separator);
        joiner = Joiner.on(separator);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Iterable<String> values = splitter.split(value.toString());
        joinKey.set(Iterables.get(values,keyIndex));
        if(keyIndex != 0){
            value.set(reorderValue(values,keyIndex));
        }
        context.write(joinKey,value);
    }


    private String reorderValue(Iterable<String> value, int index){
        List<String> temp = Lists.newArrayList(value);
        String originalFirst = temp.get(0);
        String newFirst = temp.get(index);
        temp.set(0,newFirst);
        temp.set(index,originalFirst);
        return joiner.join(temp);
    }
}
