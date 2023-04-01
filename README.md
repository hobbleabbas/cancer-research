## Condition research, written in Scala

A UI and API allowing general public to research easily their conditions. Users should be able to enter their condition, and receive back:

- A plain english summary of what it is, and key ideas as well as confusions
- Plain english summaries of currently accepted facts and indications about the condition and what the latest research indicates

## Tech stack and philosophy

The codebase will be written out in Scala, mostly because I want to learn the language and thought this would be a good way to do so. The design and idea behind this will likely change rapidly over the next few days/weeks.

The system will have the following components:
- UI 
    - Basic search engine, which intakes a condition and passes it to the API
    - Upon response, the website will display a clean, easy to use UI allowing viewer to dig in with more depth
- Backend
    - API
        - Intakes the plaintext condition name passed by user, uses ScienceIO to extract the UMLS' associated
        - Queries UMLS retriever and returns response
    - UMLS retriever
        - For any given UMLS, finds cached details from db and returns response to the user
    - UMLS processor
        - Intakes UMLS and gathers related papers, various data sources
        - Passes info to both scienceio and openai, and there should also be heuristics to filter erroneous results
        - Caches data to database for easy access 
    - Data scraper
        - Listens for new clinical trial results, Arxiv papers, and presswires (for announcements on potential remedies by pharma companies)
        - Upon receiving a new result, passes to the UMLS processer to handle and save

## Services Used

Some price trackers would also be useful here.

**Useful third parties**
- [ScienceIO](science.io) - to parse UMLS tags and key content from both data sources and user input
- [OpenAI](openai.com) - to summarize content

**Data sources**
- Arxiv
- Business Wire
- Globe News Wire
- ClinicalTrial.gov
- sec.gov (tracking financial health of companies producing treatments for a given condition)

## To build out
- [ ] ScienceIO scala client
- [ ] UMLS retriever
- [ ] UMLS processor
- [ ] Data scraper

## Ideas for improvement and potential problems
- Finding the right temp balance in using openai to summarize might be tricky, it might be a good idea to have summaries approved.