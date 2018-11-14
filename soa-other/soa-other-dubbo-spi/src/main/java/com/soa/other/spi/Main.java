package com.soa.other.spi;

import java.util.ServiceLoader;

/**
spi的设计目标：
面向的对象的设计里，模块之间是基于接口编程，模块之间不对实现类进行硬编码。
一旦代码里涉及具体的实现类，就违反了可拔插的原则，如果需要替换一种实现，就需要修改代码。
为了实现在模块装配的时候，不在模块里面写死代码，这就需要一种服务发现机制。
java spi就是提供这样的一个机制：
为某个接口寻找服务实现的机制。有点类似IOC的思想，就是将装配的控制权移到代码之外。


spi的具体约定如下  ：
当服务的提供者(provider)，提供了一个接口多种实现时，
一般会在jar包的META-INF/services/目录下，创建该接口的同名文件。
该文件里面的内容就是该服务接口的具体实现类的名称。
而当外部加载这个模块的时候，
就能通过该jar包META-INF/services/里的配置文件得到具体的实现类名，并加载实例化，完成模块的装配。
 */
public class Main {

	public static void main(String[] args) {
		ServiceLoader<Command> serviceLoader=ServiceLoader.load(Command.class);

        for(Command command:serviceLoader){  
            command.execute();  
        }  
	}

}
