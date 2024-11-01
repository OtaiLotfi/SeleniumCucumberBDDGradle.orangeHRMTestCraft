package it.otai.e2e.common;

import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import org.assertj.core.util.Strings;

import java.io.Serializable;
import java.util.*;

import static java.lang.String.format;

public class ScenarioContext implements Serializable {

  public Map<String, Object> scenarioContext;

  public ScenarioContext() {
    scenarioContext = new HashMap<>();
  }

  public void setScenarioContext(String key, Object value) {
    scenarioContext.put(key, value);
  }

  @SneakyThrows
  public Object getScenarioContext(String key) {
    var isKeyNotPresent = !isContains(key);
    if (isKeyNotPresent) {
      throw new Exception(format("Scenario context does not contain the key: %s", key));
    }
    var context = scenarioContext.get(key);
    if (Objects.isNull(context)) {
      throw new Exception(format("Scenario context is null for key: %s", key));
    }
    return context;
  }

  public boolean isContains(String key) {
    return scenarioContext.containsKey(key);
  }

  public void clear(){
    scenarioContext.clear();
  }

  public void printScenarioMessages(Scenario scenario) {
    if (scenario == null) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    getMessageList().forEach(s -> sb.append(s).append("\n"));
    String log = sb.toString();
    if (!Strings.isNullOrEmpty(log)) {
      scenario.log(log);
    }
  }

  private List<String> getMessageList() {
    List<?> messagesObj = (List<?>) scenarioContext.get(Constants.INTERNAL_MESSAGES_KEY);
    if (messagesObj != null) {
      List<String> messages = messagesObj.stream()
              .map(Object::toString)
              .toList();
      return new ArrayList<>(messages);
    }
    return new ArrayList<>();
  }
}