package ladder.domain.generator;

import ladder.domain.Rewards;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsGeneratorTest {
    @Test
    void 컴마_기준으로_나누기() {
        String input = "꽝, 5000, 꽝";
        Map<Integer, String> inputMap = new HashMap<>();
        inputMap.put(0, "꽝");
        inputMap.put(1, "5000");
        inputMap.put(2, "꽝");
        Rewards expectedRewards = new Rewards(inputMap);

        Rewards actualRewards = new RewardsGenerator(input).generate();

        assertThat(actualRewards.equals(expectedRewards)).isTrue();
    }
}
