package org.sbs.analyzers;

import org.sbs.BuildConfiguration;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeaderAnalyzer implements IAnalyzeConflict <HeaderAnalyzer, BuildConfiguration> {
    private final EventBus bus = new EventBus();
    @Override
    public HeaderAnalyzer AnalyzeResolve(BuildConfiguration Object) {
        if (!Objects.equals(Object.getWords().get(0), "<")) {
            bus.EventResolve(new AnalyzeEvent("Синтаксическая ошибка: ожидается -> '<'"));
        }
        if (!Objects.equals(Object.getWords().get(1), "?xml")) {
            bus.EventResolve(new AnalyzeEvent("Синтаксическая ошибка: ожидается -> '?xml'"));
        }
        if (!Objects.equals(Object.getWords().get(5), "?")) {
            bus.EventResolve(new AnalyzeEvent("Синтаксическая ошибка: ожидается -> '?'"));
        }
        if (!Objects.equals(Object.getWords().get(6), ">")) {
            bus.EventResolve(new AnalyzeEvent("Синтаксическая ошибка: ожидается -> '>'"));
        }
        Pattern versionCheck = Pattern.compile("^version==\"\\d.0\"");
        Matcher versionMatcher = versionCheck.matcher(Object.getWords().get(2));
        if (!versionMatcher.matches()) {
            bus.EventResolve(new AnalyzeEvent("Синтаксическая ошибка: неверный синтаксис" + Object.getWords().get(2)));
        }
        Pattern encodingCheck = Pattern.compile("^encoding==\"\\S+\"");
        Matcher encodingMatcher = encodingCheck.matcher(Object.getWords().get(3));
        if (!versionMatcher.matches()) {
            bus.EventResolve(new AnalyzeEvent("Синтаксическая ошибка: неверный синтаксис" + Object.getWords().get(3)));
        }
        return this;
    }
}
