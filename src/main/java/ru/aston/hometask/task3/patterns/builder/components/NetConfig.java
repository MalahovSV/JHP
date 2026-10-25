package ru.aston.hometask.task3.patterns.builder.components;

import java.util.Objects;

public class NetConfig {
    private String ip;
    private String mask;
    private String gate;
    private String dns;
    private String alterDns;

    public NetConfig() {}

    public NetConfig(String ip, String mask, String gate, String dns, String alterDns) {
        this.ip = ip;
        this.mask = mask;
        this.gate = gate;
        this.dns = dns;
        this.alterDns = alterDns;
    }


    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public String getMask() { return mask; }
    public void setMask(String mask) { this.mask = mask; }

    public String getGate() { return gate; }
    public void setGate(String gate) { this.gate = gate; }

    public String getDns() { return dns; }
    public void setDns(String dns) { this.dns = dns; }

    public String getAlterDns() { return alterDns; }
    public void setAlterDns(String alterDns) { this.alterDns = alterDns; }

    @Override
    public String toString() {
        return String.format(
                "IP: %-15s | Маска: %-15s | Шлюз: %-15s | DNS: %-15s | Alt DNS: %-15s",
                ip != null ? ip : "не задан",
                mask != null ? mask : "не задан",
                gate != null ? gate : "не задан",
                dns != null ? dns : "не задан",
                alterDns != null ? alterDns : "не задан"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NetConfig netConfig = (NetConfig) o;
        return Objects.equals(ip, netConfig.ip) &&
                Objects.equals(mask, netConfig.mask) &&
                Objects.equals(gate, netConfig.gate) &&
                Objects.equals(dns, netConfig.dns) &&
                Objects.equals(alterDns, netConfig.alterDns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, mask, gate, dns, alterDns);
    }
}