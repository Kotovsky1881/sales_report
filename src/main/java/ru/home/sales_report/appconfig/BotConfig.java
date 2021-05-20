package ru.home.sales_report.appconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import ru.home.sales_report.SalesReportTelegramBot;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;


    @Bean
    public SalesReportTelegramBot salesReportTelegramBot( ) {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);

        SalesReportTelegramBot salesReportTelegramBot = new SalesReportTelegramBot(options);
        salesReportTelegramBot.setBotToken(botToken);
        salesReportTelegramBot.setBotUserName(botUserName);
        salesReportTelegramBot.setWebHookPath(webHookPath);

        return salesReportTelegramBot;
    }


}
