package com.qcc.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author qianchaochen
 * @date 2020/5/4 23:19
 */
public class RoundRobinRepeat5Role extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter;
    private static final boolean AVAILABLE_ONLY_SERVERS = true;
    private static final boolean ALL_SERVERS = false;
    public static final int MAX_COUNT = 5;
    private AtomicInteger total = new AtomicInteger(0);//记数器, 最大5次, 初始次数为0
    private AtomicInteger currentIndex = new AtomicInteger(0);

    public RoundRobinRepeat5Role() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    public RoundRobinRepeat5Role(ILoadBalancer lb) {
        this();
        setLoadBalancer(lb);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();//存活的服务数
            int serverCount = allServers.size();//所有服务数量

            if ((upCount == 0) || (serverCount == 0)) {
                return null;
            }

            if (total.getAndIncrement() < MAX_COUNT) {
//                server = allServers.get(currentIndex.get());
            }else{
                total.set(0);
                if(currentIndex.incrementAndGet() >= reachableServers.size()) {
                    currentIndex.set(0);
                }
            }
                server = allServers.get(currentIndex.get());

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {
        }
        return server;
    }

    /**
     * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.
     *
     * @param modulo The modulo to bound the value of the counter.
     * @return The next value.
     */
    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, next))
                return next;
        }
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}