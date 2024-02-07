package abiP

object anagram{


        def main(args:Array[String]):Unit={


        var stra="caet"
        var strb="tace"

        if(stra.length!=strb.length){
        println("the strings are not an anagram")
        }
        else{

        var aMap=stra.map(a=>(a,1)).groupBy(_._1).mapValues(b=>b.map(_._2).sum)
        var bMap=strb.map(a=>(a,1)).groupBy(_._1).mapValues(b=>b.map(_._2).sum)


        var sum=0
        for(i<-0 until stra.length){
        sum=0
        var charM=stra.charAt(i)


        if(aMap.get(charM).isDefined&&bMap.get(charM).isDefined){
        if(aMap.get(charM).get!=bMap.get(charM).get){
        sum=sum+1
        }
        }
        else{
        sum=sum+1
        }

        }
        if(sum==0){
        println("strings are anagram")
        }
        else{
        println("strings are not an anagram")
        }


        }
        }


        }
